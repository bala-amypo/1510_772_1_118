package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository repository;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DeliveryRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<DeliveryRecord> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public DeliveryRecord save(DeliveryRecord record) {
        return repository.save(record);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
