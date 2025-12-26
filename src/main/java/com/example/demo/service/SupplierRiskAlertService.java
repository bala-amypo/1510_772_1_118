package com.example.demo.service;

import com.example.demo.model.SupplierRiskAlert;
import java.util.List;

public interface SupplierRiskAlertService {

    SupplierRiskAlert createAlert(SupplierRiskAlert alert);

    SupplierRiskAlert resolveAlert(Long alertId);

    List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId);

    List<SupplierRiskAlert> getAllAlerts();

    List<SupplierRiskAlert> findHighRiskSuppliers();

    List<SupplierRiskAlert> findUnresolvedAlerts();

    List<SupplierRiskAlert> findMediumRiskAlerts();
}
