package com.example.demo.service.impl;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.service.DelayScoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRecordRepository repository;

    public DelayScoreServiceImpl(DelayScoreRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DelayScoreRecord save(DelayScoreRecord record) {
        return repository.save(record);
    }

    @Override
    public List<DelayScoreRecord> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<DelayScoreRecord> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
