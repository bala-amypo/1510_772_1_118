package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRecordRepository repository;

    public PurchaseOrderServiceImpl(PurchaseOrderRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PurchaseOrderRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PurchaseOrderRecord> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PurchaseOrderRecord save(PurchaseOrderRecord order) {
        return repository.save(order);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
