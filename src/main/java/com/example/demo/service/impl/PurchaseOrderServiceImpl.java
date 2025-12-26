package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRecordRepository repository;

    public PurchaseOrderServiceImpl(PurchaseOrderRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po) {
        return repository.save(po);
    }

    @Override
    public PurchaseOrderRecord getPOById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PurchaseOrderRecord> getPOsBySupplier(long supplierId) {
        return repository.findBySupplierId(supplierId);
    }
}
