package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryRecordServiceImpl {

    private final DeliveryRecordRepository repo;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository repo) {
        this.repo = repo;
    }

    public DeliveryRecord recordDelivery(DeliveryRecord d) {
        return repo.save(d);
    }

    public List<DeliveryRecord> getDeliveriesByPO(long poId) {
        return repo.findByPoId(poId);
    }

    public List<DeliveryRecord> getAllDeliveries() {
        return repo.findAll();
    }
}
