package com.example.demo.service;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierRiskAlertService {

    private final SupplierRiskAlertRepository repository;

    public SupplierRiskAlertService(SupplierRiskAlertRepository repository) {
        this.repository = repository;
    }

    public List<SupplierRiskAlert> getAll() {
        return repository.findAll();
    }

    public Optional<SupplierRiskAlert> getById(Long id) {
        return repository.findById(id);
    }

    public SupplierRiskAlert save(SupplierRiskAlert alert) {
        return repository.save(alert);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
