package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DelayScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long poId;
    private Long supplierId;
    private int delayDays;
    private String delaySeverity;
    private double score;
    private LocalDateTime computedAt;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getPoId() {
        return poId;
    }
    public void setPoId(Long poId) {
        this.poId = poId;
    }

    public Long getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public int getDelayDays() {
        return delayDays;
    }
    public void setDelayDays(int delayDays) {
        this.delayDays = delayDays;
    }

    public String getDelaySeverity() {
        return delaySeverity;
    }
    public void setDelaySeverity(String delaySeverity) {
        this.delaySeverity = delaySeverity;
    }

    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

    public LocalDateTime getComputedAt() {
        return computedAt;
    }
    public void setComputedAt(LocalDateTime computedAt) {
        this.computedAt = computedAt;
    }
}
