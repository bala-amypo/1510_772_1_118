package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;

import java.util.List;
import java.util.Optional;

public class SupplierProfileServiceImpl implements SupplierProfileService {

    private final SupplierProfileRepository repo;

    public SupplierProfileServiceImpl(SupplierProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public SupplierProfile createSupplier(SupplierProfile supplier) {
        return repo.save(supplier);
    }

    @Override
    public SupplierProfile getSupplierById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
    }

    @Override
    public Optional<SupplierProfile> getBySupplierCode(String supplierCode) {
        return repo.findBySupplierCode(supplierCode);
    }

    @Override
    public List<SupplierProfile> getAllSuppliers() {
        return repo.findAll();
    }

    @Override
    public SupplierProfile updateSupplierStatus(Long id, boolean active) {
        SupplierProfile s = getSupplierById(id);
        s.setActive(active);
        return repo.save(s);
    }
}
