package com.example.demo.service;

import com.example.demo.model.DelayScore;
import java.util.List;

public interface DelayRecordScoreService {

    DelayScore computeDelayScore(Long supplierId);

    List<DelayScore> getScoresBySupplier(Long supplierId);

    DelayScore getScoreById(Long id);

    List<DelayScore> getAllScores();
}
