package com.example.demo.service.impl;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    private final SupplierRiskAlertRepository alertRepo;

    public SupplierRiskAlertServiceImpl(SupplierRiskAlertRepository alertRepo) {
        this.alertRepo = alertRepo;
    }

    @Override
    public SupplierRiskAlert createAlert(SupplierRiskAlert alert) {
        return alertRepo.save(alert);
    }
}
