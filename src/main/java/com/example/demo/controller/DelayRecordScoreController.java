package com.example.demo.controller;

import com.example.demo.model.DelayScoreRecord;

import com.example.demo.service.DelayRecordScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delay-record-scores")
public class DelayRecordScoreController {

    private final DelayRecordScoreService service;

    public DelayRecordScoreController(DelayRecordScoreService service) {
        this.service = service;
    }

    @PostMapping("/compute/{supplierId}")
    public DelayRecordScore compute(@PathVariable Long supplierId) {
        return service.computeDelayScore(supplierId);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<DelayRecordScore> bySupplier(@PathVariable Long supplierId) {
        return service.getScoresBySupplier(supplierId);
    }

    @GetMapping("/{id}")
    public DelayRecordScore byId(@PathVariable Long id) {
        return service.getScoreById(id);
    }

    @GetMapping
    public List<DelayRecordScore> all() {
        return service.getAllScores();
    }
}
