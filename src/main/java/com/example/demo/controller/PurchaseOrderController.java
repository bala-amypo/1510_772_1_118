package com.example.demo.controller;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/purchase-orders")
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<PurchaseOrderRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PurchaseOrderRecord getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));
    }

    @PostMapping
    public PurchaseOrderRecord create(@RequestBody PurchaseOrderRecord order) {
        return service.save(order);
    }

    @PutMapping("/{id}")
    public PurchaseOrderRecord update(@PathVariable Long id, @RequestBody PurchaseOrderRecord order) {
        PurchaseOrderRecord existing = service.getById(id).orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));
        existing.setOrderNumber(order.getOrderNumber());
        existing.setOrderDate(order.getOrderDate());
        existing.setAmount(order.getAmount());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
