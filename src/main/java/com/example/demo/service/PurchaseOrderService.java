package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;
import java.util.Optional;

public interface PurchaseOrderService {

    PurchaseOrderRecord save(PurchaseOrderRecord order);

    List<PurchaseOrderRecord> findAll();

    Optional<PurchaseOrderRecord> findById(Long id);

    void deleteById(Long id);
}

