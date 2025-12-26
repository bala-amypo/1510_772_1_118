package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DelayScoreService;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRecordRepository delayRepo;
    private final PurchaseOrderRecordRepository poRepo;
    private final DeliveryRecordRepository deliveryRepo;
    private final SupplierProfileRepository supplierRepo;
    private final SupplierRiskAlertService riskAlertService;

    public DelayScoreServiceImpl(DelayScoreRecordRepository delayRepo,
                                 PurchaseOrderRecordRepository poRepo,
                                 DeliveryRecordRepository deliveryRepo,
                                 SupplierProfileRepository supplierRepo,
                                 SupplierRiskAlertService riskAlertService) {
        this.delayRepo = delayRepo;
        this.poRepo = poRepo;
        this.deliveryRepo = deliveryRepo;
        this.supplierRepo = supplierRepo;
        this.riskAlertService = riskAlertService;
    }

    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {
        PurchaseOrderRecord po = poRepo.findById(poId)
                .orElseThrow(() -> new BadRequestException("Invalid PO id"));

        SupplierProfile supplier = supplierRepo.findById(po.getSupplierId())
                .orElseThrow(() -> new BadRequestException("Invalid supplier"));

        if (!supplier.getActive()) {
            throw new BadRequestException("Inactive supplier");
        }

        List<DeliveryRecord> deliveries = deliveryRepo.findByPoId(poId);
        if (deliveries.isEmpty()) {
            throw new BadRequestException("No deliveries");
        }

        DeliveryRecord last = deliveries.get(deliveries.size() - 1);

        long delay = ChronoUnit.DAYS.between(
                po.getPromisedDeliveryDate(),
                last.getActualDeliveryDate()
        );

        int delayDays = (int) Math.max(delay, 0);

        String severity = delayDays == 0 ? "ON_TIME" :
                delayDays <= 3 ? "MINOR" : "SEVERE";

        double score = Math.max(100.0 - delayDays * 10.0, 0);

        DelayScoreRecord record = new DelayScoreRecord();
        record.setPoId(poId);
        record.setSupplierId(po.getSupplierId());
        record.setDelayDays(delayDays);
        record.setDelaySeverity(severity);
        record.setScore(score);

        DelayScoreRecord saved = delayRepo.save(record);

        if ("SEVERE".equals(severity)) {
            SupplierRiskAlert alert = new SupplierRiskAlert();
            alert.setSupplierId(po.getSupplierId());
            alert.setAlertLevel("HIGH");
            alert.setMessage("Severe delivery delay");
            riskAlertService.createAlert(alert);
        }

        return saved;
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return delayRepo.findBySupplierId(supplierId);
    }

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return delayRepo.findAll();
    }
}
