package com.example.demo.service;

import com.example.demo.model.SupplierRiskAlert;
import java.util.List;

public interface SupplierRiskAlertService {

    SupplierRiskAlert createAlert(SupplierRiskAlert alert);

    SupplierRiskAlert getById(Long id);

    List<SupplierRiskAlert> getAllAlerts();

    List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId);
}
