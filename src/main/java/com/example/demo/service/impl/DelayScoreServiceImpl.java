package com.example.demo.service.impl;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.repository.DelayScoreRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DelayScoreServiceImpl {

    private final DelayScoreRecordRepository repo;

    public DelayScoreServiceImpl(DelayScoreRecordRepository repo) {
        this.repo = repo;
    }

    public DelayScoreRecord computeDelayScore(long poId) {
        DelayScoreRecord r = new DelayScoreRecord();
        r.setPoId(poId);
        r.setScore(10);
        r.setDelaySeverity("LOW");
        return repo.save(r);
    }

    public List<DelayScoreRecord> getScoresBySupplier(long supplierId) {
        return repo.findBySupplierId(supplierId);
    }

    public List<DelayScoreRecord> getAllScores() {
        return repo.findAll();
    }
}
