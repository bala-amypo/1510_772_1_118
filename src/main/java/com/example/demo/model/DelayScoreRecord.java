package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DelayScoreRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long poId;
    private Long supplierId;
    private double delayScore;

    // Getter
    public double getDelayScore() {
        return delayScore;
    }

    // Setter
    public void setDelayScore(double delayScore) {
        this.delayScore = delayScore;
    }
}
