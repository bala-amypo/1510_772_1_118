package com.example.demo.controller;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryRecordController {

    private final DeliveryRecordService service;

    public DeliveryRecordController(DeliveryRecordService service) {
        this.service = service;
    }

    @PostMapping
    public DeliveryRecord create(@RequestBody DeliveryRecord d) {
        return service.recordDelivery(d);
    }

    @GetMapping("/po/{poId}")
    public List<DeliveryRecord> byPo(@PathVariable Long poId) {
        return service.getDeliveriesByPO(poId);
    }

    @GetMapping("/{id}")
    public Optional<DeliveryRecord> get(@PathVariable Long id) {
        return service.getDeliveryById(id);
    }

    @GetMapping
    public List<DeliveryRecord> getAll() {
        return service.getAllDeliveries();
    }
}
