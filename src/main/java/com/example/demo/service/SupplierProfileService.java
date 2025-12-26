package com.example.demo.service;

import com.example.demo.model.SupplierProfile;
import java.util.List;

public interface SupplierProfileService {

    SupplierProfile save(SupplierProfile profile);

    SupplierProfile getById(Long id);

    List<SupplierProfile> getAll();
}
