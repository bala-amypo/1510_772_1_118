package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierProfileServiceImpl {
    private final SupplierProfileRepository repository;

    public SupplierProfileServiceImpl(SupplierProfileRepository repository) {
        this.repository = repository;
    }

    public SupplierProfile getBySupplierCode(String code) {
        return repository.findBySupplierCode(code).orElse(null);
    }

    public void updateSupplierStatus(Long id, boolean status) {
        SupplierProfile s = repository.findById(id).orElseThrow();
        s.setActive(status);
        repository.save(s);
    }

    public List<SupplierProfile> getAllSuppliers() {
        return repository.findAll();
    }
}
