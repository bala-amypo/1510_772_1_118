package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SupplierProfile;
import com.example.demo.service.SupplierProfileService;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierProfileController {

    private final SupplierProfileService service;

    public SupplierProfileController(SupplierProfileService service) {
        this.service = service;
    }

    @PostMapping
    public SupplierProfile create(
            @Valid @RequestBody SupplierProfile supplier) {
        return service.createSupplier(supplier);
    }

    @GetMapping
    public List<SupplierProfile> getAll() {
        return service.getAllSuppliers();
    }
}
