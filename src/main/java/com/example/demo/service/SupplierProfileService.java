package com.example.demo.service;

import com.example.demo.model.SupplierProfile;
import java.util.List;

public interface SupplierProfileService {

    // Fetch supplier by supplier code
    SupplierProfile getBySupplierCode(String supplierCode);

    // Update supplier active/inactive status
    void updateSupplierStatus(Long id, boolean status);

    // Fetch all suppliers
    List<SupplierProfile> getAllSuppliers();
}
