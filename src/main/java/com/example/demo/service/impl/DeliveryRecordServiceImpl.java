package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository deliveryRepo;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository deliveryRepo) {
        this.deliveryRepo = deliveryRepo;
    }

    @Override
    public DeliveryRecord recordDelivery(DeliveryRecord delivery) {
        return deliveryRepo.save(delivery);
    }

    @Override
    public List<DeliveryRecord> getDeliveriesByPO(Long poId) {
        return deliveryRepo.findByPoId(poId);
    }
}
