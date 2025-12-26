package com.example.demo.service.impl;

import com.example.demo.model.DelayRecordScore;
import com.example.demo.repository.DelayRecordScoreRepository;
import com.example.demo.service.DelayRecordScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DelayRecordScoreServiceImpl implements DelayRecordScoreService {

    private final DelayRecordScoreRepository repository;

    public DelayRecordScoreServiceImpl(DelayRecordScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public DelayRecordScore computeDelayScore(Long supplierId) {
        DelayRecordScore score = new DelayRecordScore();
        score.setSupplierId(supplierId);
        score.setScore(Math.random() * 100);
        return repository.save(score);
    }

    @Override
    public List<DelayRecordScore> getScoresBySupplier(Long supplierId) {
        return repository.findBySupplierId(supplierId);
    }

    @Override
    public DelayRecordScore getScoreById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DelayRecordScore not found"));
    }

    @Override
    public List<DelayRecordScore> getAllScores() {
        return repository.findAll();
    }
}
