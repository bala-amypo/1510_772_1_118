package com.example.demo.service;

import com.example.demo.model.DelayScoreRecord;
import java.util.List;
import java.util.Optional;

public interface DelayScoreService {

    List<DelayScoreRecord> getAll();

    Optional<DelayScoreRecord> getById(Long id);

    DelayScoreRecord save(DelayScoreRecord record);

    void delete(Long id);
}
