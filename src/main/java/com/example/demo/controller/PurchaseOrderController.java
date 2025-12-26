package com.example.demo.controller;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @PostMapping
    public PurchaseOrderRecord create(@RequestBody PurchaseOrderRecord po) {
        return service.createPurchaseOrder(po);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<PurchaseOrderRecord> bySupplier(@PathVariable Long supplierId) {
        return service.getPOsBySupplier(supplierId);
    }

    @GetMapping("/{id}")
    public Optional<PurchaseOrderRecord> get(@PathVariable Long id) {
        return service.getPOById(id);
    }

    @GetMapping
    public List<PurchaseOrderRecord> getAll() {
        return service.getAllPurchaseOrders();
    }
}
