package com.example.demo.controller;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/delivery-records")
public class DeliveryRecordController {

    private final DeliveryRecordService service;

    public DeliveryRecordController(DeliveryRecordService service) {
        this.service = service;
    }

    @GetMapping
    public List<DeliveryRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DeliveryRecord getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new RuntimeException("DeliveryRecord not found"));
    }

    @PostMapping
    public DeliveryRecord create(@RequestBody DeliveryRecord record) {
        return service.save(record);
    }

    @PutMapping("/{id}")
    public DeliveryRecord update(@PathVariable Long id, @RequestBody DeliveryRecord record) {
        DeliveryRecord existing = service.getById(id).orElseThrow(() -> new RuntimeException("DeliveryRecord not found"));
        existing.setDeliveryNumber(record.getDeliveryNumber());
        existing.setDeliveryDate(record.getDeliveryDate());
        existing.setDelivered(record.getDelivered());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
