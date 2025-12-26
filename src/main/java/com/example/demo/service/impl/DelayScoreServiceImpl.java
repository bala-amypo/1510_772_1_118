package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DelayScoreRecord;
import com.example.demo.model.DeliveryRecord;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.model.SupplierProfile;
import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.DelayScoreService;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRecordRepository delayScoreRecordRepository;
    private final PurchaseOrderRecordRepository poRepository;
    private final DeliveryRecordRepository deliveryRecordRepository;
    private final SupplierProfileRepository supplierProfileRepository;
    private final SupplierRiskAlertService supplierRiskAlertService;

    public DelayScoreServiceImpl(DelayScoreRecordRepository delayScoreRecordRepository,
                                 PurchaseOrderRecordRepository poRepository,
                                 DeliveryRecordRepository deliveryRecordRepository,
                                 SupplierProfileRepository supplierProfileRepository,
                                 SupplierRiskAlertService supplierRiskAlertService) {
        this.delayScoreRecordRepository = delayScoreRecordRepository;
        this.poRepository = poRepository;
        this.deliveryRecordRepository = deliveryRecordRepository;
        this.supplierProfileRepository = supplierProfileRepository;
        this.supplierRiskAlertService = supplierRiskAlertService;
    }

    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {

        PurchaseOrderRecord po = poRepository.findById(poId)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase order not found"));

        SupplierProfile supplier = supplierProfileRepository.findById(po.getSupplierId())
                .orElseThrow(() -> new BadRequestException("Invalid supplier"));

        if (!supplier.getActive()) {
            throw new BadRequestException("Supplier is inactive");
        }

        List<DeliveryRecord> deliveries = deliveryRecordRepository.findByPoId(poId);
        if (deliveries.isEmpty()) {
            throw new BadRequestException("No deliveries found for this PO");
        }

        DeliveryRecord delivery = deliveries.get(0);

        int delayDays = (int) ChronoUnit.DAYS.between(
                po.getPromisedDeliveryDate(),
                delivery.getActualDeliveryDate()
        );

        if (delayDays < 0) delayDays = 0;

        String severity;
        if (delayDays == 0) severity = "ON_TIME";
        else if (delayDays <= 3) severity = "MINOR";
        else if (delayDays <= 7) severity = "MODERATE";
        else severity = "SEVERE";

        double score = Math.max(0, 100 - delayDays * 5);

        DelayScoreRecord record = new DelayScoreRecord();
        record.setPoId(poId);
        record.setSupplierId(po.getSupplierId());
        record.setDelayDays(delayDays);
        record.setDelaySeverity(severity);
        record.setScore(score);

        DelayScoreRecord saved = delayScoreRecordRepository.save(record);

        if ("SEVERE".equals(severity)) {
            SupplierRiskAlert alert = new SupplierRiskAlert();
            alert.setSupplierId(po.getSupplierId());
            alert.setAlertLevel("HIGH");
            alert.setMessage("Severe delivery delay detected");
            supplierRiskAlertService.createAlert(alert);
        }

        return saved;
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return delayScoreRecordRepository.findBySupplierId(supplierId);
    }

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return delayScoreRecordRepository.findAll();
    }
}
