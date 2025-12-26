package com.example.demo.service;

import com.example.demo.model.SupplierRiskAlert;
import java.util.*;

public interface SupplierRiskAlertService {

    SupplierRiskAlert createAlert(SupplierRiskAlert alert);

    List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId);

    SupplierRiskAlert resolveAlert(Long id);

    List<SupplierRiskAlert> getAllAlerts();
}
