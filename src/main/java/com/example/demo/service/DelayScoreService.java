package com.example.demo.service;

import com.example.demo.model.DelayScoreRecord;
import java.util.List;
import java.util.Optional;

public interface DelayScoreService {

    DelayScoreRecord save(DelayScoreRecord record);

    List<DelayScoreRecord> findAll();

    Optional<DelayScoreRecord> findById(Long id);

    void deleteById(Long id);
}
