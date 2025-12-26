package com.example.demo.controller;

import com.example.demo.model.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierProfileController {

    private final SupplierProfileService service;

    public SupplierProfileController(SupplierProfileService service) {
        this.service = service;
    }

    @PostMapping
    public SupplierProfile createSupplier(@RequestBody SupplierProfile supplier) {
        return service.createSupplier(supplier);
    }

    @GetMapping("/{id}")
    public SupplierProfile getSupplierById(@PathVariable Long id) {
        return service.getSupplierById(id);
    }

    @GetMapping
    public List<SupplierProfile> getAllSuppliers() {
        return service.getAllSuppliers();
    }

    @PutMapping("/{id}/status")
    public SupplierProfile updateSupplierStatus(@PathVariable Long id, @RequestParam boolean active) {
        return service.updateSupplierStatus(id, active);
    }

    @GetMapping("/code/{code}")
    public SupplierProfile getBySupplierCode(@PathVariable String code) {
        return service.getBySupplierCode(code);
    }
}
