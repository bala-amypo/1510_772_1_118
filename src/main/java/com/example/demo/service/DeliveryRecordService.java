package com.example.demo.service;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryRecordService {

    private final DeliveryRecordRepository repository;

    public DeliveryRecordService(DeliveryRecordRepository repository) {
        this.repository = repository;
    }

    public List<DeliveryRecord> getAll() {
        return repository.findAll();
    }

    public Optional<DeliveryRecord> getById(Long id) {
        return repository.findById(id);
    }

    public DeliveryRecord save(DeliveryRecord record) {
        return repository.save(record);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
