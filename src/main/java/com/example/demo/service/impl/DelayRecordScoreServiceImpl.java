package com.example.demo.service.impl;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.service.DelayRecordScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DelayRecordScoreServiceImpl implements DelayRecordScoreService {

    private final DelayScoreRecordRepository repository;
    private final DelayScoreServiceImpl delayScoreService;

    public DelayRecordScoreServiceImpl(
            DelayScoreRecordRepository repository,
            DelayScoreServiceImpl delayScoreService) {
        this.repository = repository;
        this.delayScoreService = delayScoreService;
    }

    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {
        return delayScoreService.computeDelayScore(poId);
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return repository.findBySupplierId(supplierId);
    }

    @Override
    public DelayScoreRecord getScoreById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return repository.findAll();
    }
}
