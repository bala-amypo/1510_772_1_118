package com.example.demo.controller;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-alerts")
public class SupplierRiskAlertController {

    private final SupplierRiskAlertService service;

    public SupplierRiskAlertController(SupplierRiskAlertService service) {
        this.service = service;
    }

    @PostMapping
    public SupplierRiskAlert create(@RequestBody SupplierRiskAlert a) {
        return service.createAlert(a);
    }

    @PutMapping("/{id}/resolve")
    public SupplierRiskAlert resolve(@PathVariable Long id) {
        return service.resolveAlert(id);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<SupplierRiskAlert> bySupplier(@PathVariable Long supplierId) {
        return service.getAlertsBySupplier(supplierId);
    }

    @GetMapping("/{id}")
    public SupplierRiskAlert get(@PathVariable Long id) {
        return service.getAllAlerts().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @GetMapping
    public List<SupplierRiskAlert> getAll() {
        return service.getAllAlerts();
    }
}
