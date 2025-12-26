package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DelayScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;
    private Long poId;
    private int delayDays;
    private String delaySeverity;
    private double score;
    private LocalDateTime computedAt = LocalDateTime.now();

    // Default constructor
    public DelayScoreRecord() {}

    // Getters
    public Long getId() {
        return id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public Long getPoId() {
        return poId;
    }

    public int getDelayDays() {
        return delayDays;
    }

    public String getDelaySeverity() {
        return delaySeverity;
    }

    public double getScore() {
        return score;
    }

    public LocalDateTime getComputedAt() {
        return computedAt;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setPoId(Long poId) {
        this.poId = poId;
    }

    public void setDelayDays(int delayDays) {
        this.delayDays = delayDays;
    }

    public void setDelaySeverity(String delaySeverity) {
        this.delaySeverity = delaySeverity;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setComputedAt(LocalDateTime computedAt) {
        this.computedAt = computedAt;
    }
}
