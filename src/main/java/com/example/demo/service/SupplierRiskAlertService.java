package com.example.demo.service;

import com.example.demo.model.SupplierRiskAlert;

import java.util.List;
import java.util.Optional;

public interface SupplierRiskAlertService {

    SupplierRiskAlert save(SupplierRiskAlert alert);

    Optional<SupplierRiskAlert> getById(Long id);

    List<SupplierRiskAlert> getAll();

    List<SupplierRiskAlert> getBySupplier(Long supplierId);

    SupplierRiskAlert resolveAlert(Long id);

    void createAlertForSupplier(Long supplierId, String level, String message);
}
