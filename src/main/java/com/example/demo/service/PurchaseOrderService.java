package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;
import java.util.Optional;

public interface PurchaseOrderService {

    List<PurchaseOrderRecord> getAll();

    Optional<PurchaseOrderRecord> getById(Long id); // ⚠️ MUST be Optional

    PurchaseOrderRecord save(PurchaseOrderRecord order);

    void delete(Long id);
}
