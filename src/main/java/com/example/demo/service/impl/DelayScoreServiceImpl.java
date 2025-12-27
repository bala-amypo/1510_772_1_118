package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DelayScoreService;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRecordRepository delayScoreRecordRepository;
    private final PurchaseOrderRecordRepository poRepository;
    private final DeliveryRecordRepository deliveryRepository;
    private final SupplierProfileRepository supplierProfileRepository;
    private final SupplierRiskAlertService riskAlertService;

    public DelayScoreServiceImpl(DelayScoreRecordRepository delayScoreRecordRepository,
                                 PurchaseOrderRecordRepository poRepository,
                                 DeliveryRecordRepository deliveryRepository,
                                 SupplierProfileRepository supplierProfileRepository,
                                 SupplierRiskAlertService riskAlertService) {
        this.delayScoreRecordRepository = delayScoreRecordRepository;
        this.poRepository = poRepository;
        this.deliveryRepository = deliveryRepository;
        this.supplierProfileRepository = supplierProfileRepository;
        this.riskAlertService = riskAlertService;
    }

    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {
        PurchaseOrderRecord po = poRepository.findById(poId)
                .orElseThrow(() -> new BadRequestException("PO not found"));

        SupplierProfile supplier = supplierProfileRepository.findById(po.getSupplierId())
                .orElseThrow(() -> new BadRequestException("Supplier not found"));

        if (!supplier.getActive()) {
            throw new BadRequestException("Inactive supplier");
        }

        List<DeliveryRecord> deliveries = deliveryRepository.findByPoId(poId);
        if (deliveries == null || deliveries.isEmpty()) {
            throw new BadRequestException("No deliveries found for PO");
        }

        // Logic uses the latest delivery per rules
        DeliveryRecord delivery = deliveries.get(deliveries.size() - 1);
        long delayDays = ChronoUnit.DAYS.between(po.getPromisedDeliveryDate(), delivery.getActualDeliveryDate());

        DelayScoreRecord record = new DelayScoreRecord();
        record.setPoId(poId);
        record.setSupplierId(po.getSupplierId());
        record.setDelayDays((int) delayDays);

        // Map Severity (Requirement 2.4)
        if (delayDays <= 0) {
            record.setDelaySeverity("ON_TIME");
        } else if (delayDays <= 3) {
            record.setDelaySeverity("MINOR");
        } else if (delayDays <= 7) {
            record.setDelaySeverity("MODERATE");
        } else {
            record.setDelaySeverity("SEVERE");
        }

        // Calculate Score (Requirement 2.4/5)
        double score = 100.0 - (delayDays * 5.0);
        record.setScore(Math.max(0.0, score));

        // Requirement 6.4: Trigger alert if SEVERE
        if ("SEVERE".equals(record.getDelaySeverity())) {
            SupplierRiskAlert alert = new SupplierRiskAlert();
            alert.setSupplierId(po.getSupplierId());
            alert.setAlertLevel("HIGH");
            alert.setDescription("Critical delay detected");
            riskAlertService.createAlert(alert);
        }

        return delayScoreRecordRepository.save(record);
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