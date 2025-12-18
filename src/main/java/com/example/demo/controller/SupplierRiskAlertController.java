package com.example.demo.controller;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/supplier-risk-alerts")
public class SupplierRiskAlertController {

    private final SupplierRiskAlertService service;

    public SupplierRiskAlertController(SupplierRiskAlertService service) {
        this.service = service;
    }

    @GetMapping
    public List<SupplierRiskAlert> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SupplierRiskAlert getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new RuntimeException("SupplierRiskAlert not found"));
    }

    @PostMapping
    public SupplierRiskAlert create(@RequestBody SupplierRiskAlert alert) {
        return service.save(alert);
    }

    @PutMapping("/{id}")
    public SupplierRiskAlert update(@PathVariable Long id, @RequestBody SupplierRiskAlert alert) {
        SupplierRiskAlert existing = service.getById(id).orElseThrow(() -> new RuntimeException("SupplierRiskAlert not found"));
        existing.setSupplierId(alert.getSupplierId());
        existing.setMessage(alert.getMessage());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
