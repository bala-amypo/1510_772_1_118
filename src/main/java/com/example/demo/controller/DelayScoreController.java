package com.example.demo.controller;

import com.example.demo.model.DelayScore;
import com.example.demo.service.DelayScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delay-scores")
public class DelayScoreController {

    private final DelayScoreService service;

    public DelayScoreController(DelayScoreService service) {
        this.service = service;
    }

    @PostMapping("/compute/{supplierId}")
    public DelayScore compute(@PathVariable Long supplierId) {
        return service.computeDelayScore(supplierId);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<DelayScore> bySupplier(@PathVariable Long supplierId) {
        return service.getScoresBySupplier(supplierId);
    }

    @GetMapping("/{id}")
    public DelayScore byId(@PathVariable Long id) {
        return service.getScoreById(id);
    }

    @GetMapping
    public List<DelayScore> all() {
        return service.getAllScores();
    }
}
