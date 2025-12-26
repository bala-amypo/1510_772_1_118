package com.example.demo.repository;

import com.example.demo.model.SupplierProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SupplierProfileRepository extends JpaRepository<SupplierProfile, Long> {

    // Spring Data JPA automatically implements this method
    Optional<SupplierProfile> findBySupplierCode(String supplierCode);
}
