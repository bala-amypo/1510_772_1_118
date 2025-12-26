package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository repository;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeliveryRecord save(DeliveryRecord record) {
        return repository.save(record);
    }

    @Override
    public DeliveryRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DeliveryRecord> getBySupplier(Long supplierId) {
        return repository.findBySupplierId(supplierId);
    }

    @Override
    public List<DeliveryRecord> getByPurchaseOrder(Long poId) {
        return repository.findByPoId(poId);
    }

    @Override
    public List<DeliveryRecord> getAll() {
        return repository.findAll();
    }
}
