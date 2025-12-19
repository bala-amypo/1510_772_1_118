package com.example.demo.service;

import java.util.List;
import com.example.demo.model.SupplierProfile;

public interface SupplierProfileService {

    SupplierProfile createSupplier(SupplierProfile supplier);

    List<SupplierProfile> getAllSuppliers();
}

