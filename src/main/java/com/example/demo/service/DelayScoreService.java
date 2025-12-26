package com.example.demo.service;

import com.example.demo.model.DelayScore;
import com.example.demo.repository.DelayScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DelayScoreService {

    private final DelayScoreRepository repository;

    public DelayScoreService(DelayScoreRepository repository) {
        this.repository = repository;
    }

    public DelayScore save(DelayScore score) {
        return repository.save(score);
    }

    public List<DelayScore> findAll() {
        return repository.findAll();
    }

    public DelayScore findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DelayScore not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
