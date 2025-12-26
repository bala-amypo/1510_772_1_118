package com.example.demo.service.impl;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    private final SupplierRiskAlertRepository repository;

    public SupplierRiskAlertServiceImpl(SupplierRiskAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplierRiskAlert createAlert(SupplierRiskAlert alert) {
        return repository.save(alert);
    }

    @Override
    public SupplierRiskAlert getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<SupplierRiskAlert> getAllAlerts() {
        return repository.findAll();
    }

    @Override
    public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
        return repository.findBySupplierId(supplierId);
    }
}
