package com.example.demo.service;

import com.example.demo.model.DelayRecordScore;
import java.util.List;

public interface DelayRecordScoreService {

    DelayRecordScore computeDelayScore(Long supplierId);

    List<DelayRecordScore> getScoresBySupplier(Long supplierId);

    DelayRecordScore getScoreById(Long id);

    List<DelayRecordScore> getAllScores();
}
