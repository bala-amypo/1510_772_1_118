package com.example.demo.service;

import com.example.demo.model.DeliveryRecord;
import java.util.List;

public interface DeliveryRecordService {
    DeliveryRecord save(DeliveryRecord record);
    List<DeliveryRecord> getBySupplier(Long supplierId);
    List<DeliveryRecord> getAll();
}
