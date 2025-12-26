package com.example.demo.service;

import com.example.demo.model.SupplierRiskAlert;
import java.util.List;
import java.util.Optional;

public interface SupplierRiskAlertService {

    List<SupplierRiskAlert> getAll();

    Optional<SupplierRiskAlert> getById(Long id);

    SupplierRiskAlert save(SupplierRiskAlert alert);

    void delete(Long id);
}
