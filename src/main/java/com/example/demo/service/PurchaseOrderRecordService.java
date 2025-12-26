package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderRecordService {

    PurchaseOrderRecord save(PurchaseOrderRecord po);

    Optional<PurchaseOrderRecord> getById(Long id);

    List<PurchaseOrderRecord> getBySupplier(Long supplierId);

    List<PurchaseOrderRecord> getAll();
}
