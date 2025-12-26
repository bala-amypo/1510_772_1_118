package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;

public interface PurchaseOrderService {

    List<PurchaseOrderRecord> getAll();

    PurchaseOrderRecord getById(Long id);

    PurchaseOrderRecord save(PurchaseOrderRecord order);

    void delete(Long id);
}
