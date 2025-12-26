package com.example.demo.repository;

import com.example.demo.model.DelayRecordScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DelayRecordScoreRepository extends JpaRepository<DelayRecordScore, Long> {

    List<DelayRecordScore> findBySupplierId(Long supplierId);
}
