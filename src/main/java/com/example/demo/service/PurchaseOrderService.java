package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRecordRepository repository;

    public PurchaseOrderService(PurchaseOrderRecordRepository repository) {
        this.repository = repository;
    }

    public List<PurchaseOrderRecord> getAll() {
        return repository.findAll();
    }

    public Optional<PurchaseOrderRecord> getById(Long id) {
        return repository.findById(id);
    }

    public PurchaseOrderRecord save(PurchaseOrderRecord order) {
        return repository.save(order);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
