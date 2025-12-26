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
    public DelayRecordScore save(DelayRecordScore score) {
        return repository.save(score);
    }

    @Override
    public List<DelayRecordScore> findAll() {
        return repository.findAll();
    }

    @Override
    public DelayRecordScore findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
