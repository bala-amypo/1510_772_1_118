package com.example.demo.service;

import com.example.demo.model.SupplierProfile;
import java.util.List;

public interface SupplierProfileService {
    SupplierProfile createSupplier(SupplierProfile supplier);
    List<SupplierProfile> getAllSuppliers(); // <-- add this
}
