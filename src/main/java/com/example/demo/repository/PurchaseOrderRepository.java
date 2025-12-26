package com.example.demo.repository;

import com.example.demo.model.PurchaseOrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository
        extends JpaRepository<PurchaseOrderRecord, Long> {
}
