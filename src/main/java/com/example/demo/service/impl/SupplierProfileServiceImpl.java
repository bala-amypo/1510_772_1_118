package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    private final SupplierProfileRepository repository;

    public SupplierProfileServiceImpl(SupplierProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplierProfile save(SupplierProfile profile) {
        return repository.save(profile);
    }

    @Override
    public SupplierProfile getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<SupplierProfile> getAll() {
        return repository.findAll();
    }
}
