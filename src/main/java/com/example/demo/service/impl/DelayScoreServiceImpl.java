package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DelayScoreServiceImpl {

    private final DelayScoreRecordRepository delayRepo;
    private final PurchaseOrderRecordRepository poRepo;
    private final DeliveryRecordRepository deliveryRepo;
    private final SupplierProfileRepository supplierRepo;
    private final SupplierRiskAlertService riskAlertService;

    public DelayScoreServiceImpl(
            DelayScoreRecordRepository delayRepo,
            PurchaseOrderRecordRepository poRepo,
            DeliveryRecordRepository deliveryRepo,
            SupplierProfileRepository supplierRepo,
            SupplierRiskAlertService riskAlertService
    ) {
        this.delayRepo = delayRepo;
        this.poRepo = poRepo;
        this.deliveryRepo = deliveryRepo;
        this.supplierRepo = supplierRepo;
        this.riskAlertService = riskAlertService;
    }

    public DelayScoreRecord computeDelayScore(Long poId) {
        PurchaseOrderRecord po = poRepo.findById(poId)
                .orElseThrow(() -> new BadRequestException("Invalid PO"));

        SupplierProfile supplier = supplierRepo.findById(po.getSupplierId())
                .orElseThrow(() -> new BadRequestException("Invalid supplier"));

        if (!supplier.getActive())
            throw new BadRequestException("Inactive supplier");

        List<DeliveryRecord> deliveries = deliveryRepo.findByPoId(poId);
        if (deliveries.isEmpty())
            throw new BadRequestException("No deliveries");

        DeliveryRecord last = deliveries.get(deliveries.size() - 1);
        long delay = ChronoUnit.DAYS.between(po.getPromisedDeliveryDate(), last.getActualDeliveryDate());
        int delayDays = (int) Math.max(0, delay);

        String severity = delayDays == 0 ? "ON_TIME" :
                delayDays <= 3 ? "MINOR" :
                        delayDays <= 7 ? "MEDIUM" : "SEVERE";

        DelayScoreRecord record = delayRepo.findByPoId(poId).orElse(new DelayScoreRecord());
        record.setPoId(poId);
        record.setSupplierId(po.getSupplierId());
        record.setDelayDays(delayDays);
        record.setDelaySeverity(severity);
        record.setScore(100.0 - delayDays * 5);

        return delayRepo.save(record);
    }

    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return delayRepo.findBySupplierId(supplierId);
    }

    public List<DelayScoreRecord> getAllScores() {
        return delayRepo.findAll();
    }
}
