package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;

public interface PurchaseOrderService {

    List<PurchaseOrderRecord> getAllOrders();

    PurchaseOrderRecord createOrder(PurchaseOrderRecord order);

    void delete(Long id);
}
