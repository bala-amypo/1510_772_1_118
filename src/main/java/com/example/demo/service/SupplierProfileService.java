package com.example.demo.service;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierProfileService {

    private final SupplierProfileRepository repository;

    public SupplierProfileService(SupplierProfileRepository repository) {
        this.repository = repository;
    }

    public List<SupplierProfile> getAll() {
        return repository.findAll();
    }

    public Optional<SupplierProfile> getById(Long id) {
        return repository.findById(id);
    }

    public SupplierProfile save(SupplierProfile profile) {
        return repository.save(profile);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
