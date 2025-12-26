package com.example.demo.service;

import com.example.demo.model.DeliveryRecord;

import java.util.List;
import java.util.Optional;

public interface DeliveryRecordService {
    DeliveryRecord save(DeliveryRecord record);
    Optional<DeliveryRecord> getById(Long id);
    List<DeliveryRecord> getBySupplier(Long supplierId);
    List<DeliveryRecord> getByPurchaseOrder(Long poId);
    List<DeliveryRecord> getAll();
}
