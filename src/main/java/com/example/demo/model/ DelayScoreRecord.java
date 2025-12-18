package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DelayScoreRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long supplierId;
    private Integer delayScore;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }
    public Integer getDelayScore() { return delayScore; }
    public void setDelayScore(Integer delayScore) { this.delayScore = delayScore; }
}
