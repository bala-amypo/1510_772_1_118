package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl {

    private final PurchaseOrderRecordRepository repo;

    public PurchaseOrderServiceImpl(PurchaseOrderRecordRepository repo) {
        this.repo = repo;
    }

    public PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po) {
        return repo.save(po);
    }

    public List<PurchaseOrderRecord> getPOsBySupplier(long supplierId) {
        return repo.findBySupplierId(supplierId);
    }

    public PurchaseOrderRecord getPOById(long id) {
        return repo.findById(id).orElse(null);
    }
}
