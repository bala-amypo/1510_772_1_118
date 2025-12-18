package com.example.demo.controller;

import com.example.demo.model.DelayScoreRecord;
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

    @GetMapping
    public List<DelayScoreRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DelayScoreRecord getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new RuntimeException("DelayScoreRecord not found"));
    }

    @PostMapping
    public DelayScoreRecord create(@RequestBody DelayScoreRecord record) {
        return service.save(record);
    }

    @PutMapping("/{id}")
    public DelayScoreRecord update(@PathVariable Long id, @RequestBody DelayScoreRecord record) {
        DelayScoreRecord existing = service.getById(id).orElseThrow(() -> new RuntimeException("DelayScoreRecord not found"));
        existing.setSupplierId(record.getSupplierId());
        existing.setDelayScore(record.getDelayScore());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
