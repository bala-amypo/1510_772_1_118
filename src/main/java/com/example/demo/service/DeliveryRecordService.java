package com.example.demo.service;

import com.example.demo.model.DeliveryRecord;
import java.util.List;
import java.util.Optional;

public interface DeliveryRecordService {

    DeliveryRecord save(DeliveryRecord record);

    List<DeliveryRecord> findAll();

    Optional<DeliveryRecord> findById(Long id);

    void deleteById(Long id);
}
