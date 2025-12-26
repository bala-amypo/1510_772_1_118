package com.example.demo.service;

import com.example.demo.model.SupplierProfile;
import java.util.List;
import java.util.Optional;

public interface SupplierProfileService {

    SupplierProfile save(SupplierProfile supplier);

    List<SupplierProfile> findAll();

    Optional<SupplierProfile> findById(Long id);

    void deleteById(Long id);
}
