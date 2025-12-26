package com.example.demo.controller;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
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
    public DeliveryRecord get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<DeliveryRecord> all() {
        return service.getAll();
    }

    @GetMapping("/po/{poId}")
    public List<DeliveryRecord> byPo(@PathVariable Long poId) {
        return service.getByPurchaseOrder(poId);
    }
}
