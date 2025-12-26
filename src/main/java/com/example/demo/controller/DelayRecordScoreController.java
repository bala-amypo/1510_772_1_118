package com.example.demo.controller;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.service.DelayRecordScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delay-scores")
public class DelayRecordScoreController {

    private final DelayRecordScoreService service;

    public DelayRecordScoreController(DelayRecordScoreService service) {
        this.service = service;
    }

    @PostMapping("/{poId}")
    public ResponseEntity<DelayScoreRecord> compute(@PathVariable Long poId) {
        return ResponseEntity.ok(service.computeDelayScore(poId));
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<DelayScoreRecord>> bySupplier(@PathVariable Long supplierId) {
        return ResponseEntity.ok(service.getScoresBySupplier(supplierId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DelayScoreRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getScoreById(id));
    }

    @GetMapping
    public ResponseEntity<List<DelayScoreRecord>> all() {
        return ResponseEntity.ok(service.getAllScores());
    }
}
