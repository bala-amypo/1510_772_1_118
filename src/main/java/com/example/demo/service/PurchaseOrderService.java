package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;

public interface PurchaseOrderRecordService {

    PurchaseOrderRecord save(PurchaseOrderRecord order);

    PurchaseOrderRecord getById(Long id);

    List<PurchaseOrderRecord> getBySupplier(Long supplierId);

    List<PurchaseOrderRecord> getAll();
}
