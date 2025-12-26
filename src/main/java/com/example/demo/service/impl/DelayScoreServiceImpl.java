package com.example.demo.service.impl;

import com.example.demo.model.DelayScore;
import com.example.demo.repository.DelayScoreRepository;
import com.example.demo.service.DelayScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRepository repository;

    public DelayScoreServiceImpl(DelayScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public DelayScore computeDelayScore(Long supplierId) {
        DelayScore score = new DelayScore();
        score.setSupplierId(supplierId);
        score.setScore(Math.random() * 100);
        return repository.save(score);
    }

    @Override
    public List<DelayScore> getScoresBySupplier(Long supplierId) {
        return repository.findBySupplierId(supplierId);
    }

    @Override
    public DelayScore getScoreById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DelayScore not found"));
    }

    @Override
    public List<DelayScore> getAllScores() {
        return repository.findAll();
    }
}
    