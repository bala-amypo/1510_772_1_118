package com.example.demo.service;

import com.example.demo.model.SupplierRiskAlert;
import java.util.List;
import java.util.Optional;

public interface SupplierRiskAlertService {

    SupplierRiskAlert save(SupplierRiskAlert alert);

    List<SupplierRiskAlert> findAll();

    Optional<SupplierRiskAlert> findById(Long id);

    void deleteById(Long id);
}
