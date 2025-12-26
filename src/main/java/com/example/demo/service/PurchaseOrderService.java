package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import java.util.*;

public interface PurchaseOrderService {

    PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po);

    List<PurchaseOrderRecord> getPOsBySupplier(Long supplierId);

    Optional<PurchaseOrderRecord> getPOById(Long id);

    List<PurchaseOrderRecord> getAllPurchaseOrders();
}
