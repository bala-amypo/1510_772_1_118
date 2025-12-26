package com.example.demo.service;

import com.example.demo.model.DeliveryRecord;
import java.util.List;

public interface DeliveryRecordService {

    DeliveryRecord save(DeliveryRecord record);

    DeliveryRecord getById(Long id);

    List<DeliveryRecord> getBySupplier(Long supplierId);

    List<DeliveryRecord> getByPurchaseOrder(Long poId);

    List<DeliveryRecord> getAll();
}
