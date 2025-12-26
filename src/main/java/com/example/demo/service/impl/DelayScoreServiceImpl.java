package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.DelayScoreRecord;
import com.example.demo.repository.*;
import com.example.demo.service.DelayScoreService;
import com.example.demo.service.SupplierRiskAlertService;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRecordRepository delayRepo;
    private final PurchaseOrderRecordRepository poRepo;
    private final DeliveryRecordRepository deliveryRepo;
    private final SupplierProfileRepository supplierRepo;
    private final SupplierRiskAlertService alertService;

    public DelayScoreServiceImpl(
            DelayScoreRecordRepository delayRepo,
            PurchaseOrderRecordRepository poRepo,
            DeliveryRecordRepository deliveryRepo,
            SupplierProfileRepository supplierRepo,
            SupplierRiskAlertService alertService) {
        this.delayRepo = delayRepo;
        this.poRepo = poRepo;
        this.deliveryRepo = deliveryRepo;
        this.supplierRepo = supplierRepo;
        this.alertService = alertService;
    }

    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {
        var po = poRepo.findById(poId).orElseThrow();
        var supplier = supplierRepo.findById(po.getSupplierId()).orElseThrow();

        if (!supplier.getActive()) throw new BadRequestException("Inactive supplier");

        var deliveries = deliveryRepo.findByPoId(poId);
        if (deliveries.isEmpty()) throw new BadRequestException("No deliveries");

        var d = deliveries.get(0);
        int delay = (int) ChronoUnit.DAYS.between(po.getPromisedDeliveryDate(), d.getActualDeliveryDate());
        if (delay < 0) delay = 0;

        String sev = delay == 0 ? "ON_TIME" : delay <= 3 ? "MINOR" : delay <= 7 ? "MODERATE" : "SEVERE";
        double score = Math.max(0, 100 - delay * 5);

        DelayScoreRecord r = new DelayScoreRecord();
        r.setPoId(poId);
        r.setSupplierId(po.getSupplierId());
        r.setDelayDays(delay);
        r.setDelaySeverity(sev);
        r.setScore(score);

        return delayRepo.save(r);
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return delayRepo.findBySupplierId(supplierId);
    }

    @Override
    public Optional<DelayScoreRecord> getScoreById(Long id) {
        return delayRepo.findById(id);
    }

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return delayRepo.findAll();
    }
}
