package com.example.demo.controller;

import com.example.demo.model.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierProfileController {

    private final SupplierProfileService service;

    public SupplierProfileController(SupplierProfileService service) {
        this.service = service;
    }

    @PostMapping
    public SupplierProfile create(@RequestBody SupplierProfile supplier) {
        return service.createSupplier(supplier);
    }

    @GetMapping("/{id}")
    public SupplierProfile getById(@PathVariable Long id) {
        return service.getSupplierById(id);
    }

    @GetMapping
    public List<SupplierProfile> getAll() {
        return service.getAllSuppliers();
    }

    @PatchMapping("/{id}/status")
    public SupplierProfile updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return service.updateSupplierStatus(id, active);
    }

    @GetMapping("/code/{code}")
    public Optional<SupplierProfile> getByCode(@PathVariable String code) {
        return service.getBySupplierCode(code);
    }
}
