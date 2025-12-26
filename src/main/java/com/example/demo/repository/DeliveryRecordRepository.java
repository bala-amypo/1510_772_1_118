package com.example.demo.repository;

import com.example.demo.model.DeliveryRecord;

import java.util.List;
import java.util.Optional;

public interface DeliveryRecordRepository {

    Optional<DeliveryRecord> findById(Long id);

    List<DeliveryRecord> findByPoId(Long poId);

    List<DeliveryRecord> findAll();

    DeliveryRecord save(DeliveryRecord delivery);
}
