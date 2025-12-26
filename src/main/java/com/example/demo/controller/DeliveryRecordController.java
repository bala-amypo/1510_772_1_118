package com.example.demo.controller;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryRecordController {

    private final DeliveryRecordService service;

    public DeliveryRecordController(DeliveryRecordService service) {
        this.service = service;
    }

    @PostMapping
    public DeliveryRecord save(@RequestBody DeliveryRecord record) {
        return service.save(record);
    }

    @GetMapping("/{id}")
    public DeliveryRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<DeliveryRecord> getBySupplier(@PathVariable Long supplierId) {
        return service.getBySupplier(supplierId);
    }

    @GetMapping("/po/{poId}")
    public List<DeliveryRecord> getByPurchaseOrder(@PathVariable Long poId) {
        return service.getByPurchaseOrder(poId);
    }

    @GetMapping
    public List<DeliveryRecord> getAll() {
        return service.getAll();
    }
}
