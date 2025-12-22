package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;

@Service
public class SupplierProfileService {

    private final SupplierProfileRepository repository;

    public SupplierProfileService(SupplierProfileRepository repository) {
        this.repository = repository;
    }

    public SupplierProfile createSupplier(SupplierProfile supplier) {
        return repository.save(supplier);
    }

    public List<SupplierProfile> getAllSuppliers() {
        return repository.findAll();
    }
}

