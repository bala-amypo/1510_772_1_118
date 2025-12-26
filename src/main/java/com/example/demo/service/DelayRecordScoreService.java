package com.example.demo.service;

import com.example.demo.model.DelayRecordScore;

import java.util.List;

public interface DelayRecordScoreService {
    DelayRecordScore save(DelayRecordScore score);
    List<DelayRecordScore> findAll();
    DelayRecordScore findById(Long id);
    void deleteById(Long id);
}
