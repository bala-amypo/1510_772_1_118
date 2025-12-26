package com.example.demo.service.impl;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    private final SupplierRiskAlertRepository repository;

    public SupplierRiskAlertServiceImpl(SupplierRiskAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SupplierRiskAlert> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SupplierRiskAlert> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public SupplierRiskAlert save(SupplierRiskAlert alert) {
        return repository.save(alert);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
