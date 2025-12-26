package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
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
        if (alert.getSupplierId() == null) {
            throw new BadRequestException("Supplier ID is required");
        }
        alert.setResolved(false); // default
        return repository.save(alert);
    }

    @Override
    public SupplierRiskAlert resolveAlert(Long id) {
        SupplierRiskAlert alert = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found with id " + id));
        alert.setResolved(true);
        return repository.save(alert);
    }

    @Override
    public SupplierRiskAlert getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found with id " + id));
    }

    @Override
    public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
        return repository.findBySupplierId(supplierId);
    }

    @Override
    public List<SupplierRiskAlert> getAllAlerts() {
        return repository.findAll();
    }
}
