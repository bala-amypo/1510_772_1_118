package com.example.demo.controller;

import com.example.demo.model.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/supplier-profiles")
public class SupplierProfileController {

    private final SupplierProfileService service;

    public SupplierProfileController(SupplierProfileService service) {
        this.service = service;
    }

    @GetMapping
    public List<SupplierProfile> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SupplierProfile getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new RuntimeException("SupplierProfile not found"));
    }

    @PostMapping
    public SupplierProfile create(@RequestBody SupplierProfile profile) {
        return service.save(profile);
    }

    @PutMapping("/{id}")
    public SupplierProfile update(@PathVariable Long id, @RequestBody SupplierProfile profile) {
        SupplierProfile existing = service.getById(id).orElseThrow(() -> new RuntimeException("SupplierProfile not found"));
        existing.setName(profile.getName());
        existing.setEmail(profile.getEmail());
        existing.setPhone(profile.getPhone());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
