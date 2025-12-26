package com.example.demo.controller;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.service.PurchaseOrderRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderRecordController {

    private final PurchaseOrderRecordService service;

    public PurchaseOrderRecordController(PurchaseOrderRecordService service) {
        this.service = service;
    }

    @PostMapping
    public PurchaseOrderRecord save(@RequestBody PurchaseOrderRecord order) {
        return service.save(order);
    }

    @GetMapping("/{id}")
    public PurchaseOrderRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<PurchaseOrderRecord> getBySupplier(@PathVariable Long supplierId) {
        return service.getBySupplier(supplierId);
    }

    @GetMapping
    public List<PurchaseOrderRecord> getAll() {
        return service.getAll();
    }
}
