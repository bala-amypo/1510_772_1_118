package com.example.demo.service;

import com.example.demo.model.DeliveryRecord;
import java.util.List;
import java.util.Optional;

public interface DeliveryRecordService {

    List<DeliveryRecord> getAll();

    Optional<DeliveryRecord> getById(Long id);

    DeliveryRecord save(DeliveryRecord record);

    void delete(Long id);
}
