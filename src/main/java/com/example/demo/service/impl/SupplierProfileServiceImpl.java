package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    @Autowired
    private SupplierProfileRepository supplierProfileRepository;

    @Override
    public SupplierProfile getSupplierById(long id) {
        return supplierProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + id));
    }

    @Override
    public SupplierProfile updateSupplierStatus(long id, boolean active) {
        SupplierProfile supplier = getSupplierById(id);
        supplier.setActive(active);
        return supplierProfileRepository.save(supplier);
    }

    @Override
    public SupplierProfile getBySupplierCode(String code) {
        return supplierProfileRepository.findBySupplierCode(code)
                .orElseThrow(() -> new RuntimeException("Supplier not found with code: " + code));
    }
}
