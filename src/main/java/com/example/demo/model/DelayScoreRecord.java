package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DelayScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int delayScore;

    public Long getId() { return id; }

    public int getDelayScore() { return delayScore; }
    public void setDelayScore(int delayScore) { this.delayScore = delayScore; }
}
