package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.service.PurchaseOrderRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderRecordServiceImpl implements PurchaseOrderRecordService {

    private final PurchaseOrderRecordRepository repository;

    public PurchaseOrderRecordServiceImpl(PurchaseOrderRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseOrderRecord save(PurchaseOrderRecord order) {
        return repository.save(order);
    }

    @Override
    public PurchaseOrderRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PurchaseOrderRecord> getBySupplier(Long supplierId) {
        return repository.findBySupplierId(supplierId);
    }

    @Override
    public List<PurchaseOrderRecord> getAll() {
        return repository.findAll();
    }
}
