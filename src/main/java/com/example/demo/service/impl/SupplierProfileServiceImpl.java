package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    private final SupplierProfileRepository supplierProfileRepository;

    @Autowired
    public SupplierProfileServiceImpl(SupplierProfileRepository supplierProfileRepository) {
        this.supplierProfileRepository = supplierProfileRepository;
    }

    @Override
    public SupplierProfile getSupplierById(Long id) {
        return supplierProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
    }

    @Override
    public SupplierProfile createSupplier(SupplierProfile supplier) {
        // Validation: Ensure unique supplier code (Requirement 6.1)
        if (supplierProfileRepository.findBySupplierCode(supplier.getSupplierCode()).isPresent()) {
            throw new IllegalArgumentException("Supplier code already exists: " + supplier.getSupplierCode());
        }
        return supplierProfileRepository.save(supplier);
    }

    @Override
    public List<SupplierProfile> getAllSuppliers() {
        return supplierProfileRepository.findAll();
    }

    @Override
    public SupplierProfile updateSupplierStatus(Long id, Boolean active) {
        SupplierProfile supplier = getSupplierById(id);
        supplier.setActive(active);
        return supplierProfileRepository.save(supplier);
    }

    @Override
    public Optional<SupplierProfile> getBySupplierCode(String supplierCode) {
        return supplierProfileRepository.findBySupplierCode(supplierCode);
    }
}