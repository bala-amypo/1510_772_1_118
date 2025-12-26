package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SupplierRiskAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    // Default constructor
    public SupplierRiskAlert() {}

    // Getters and Setters
    public Long getId() { return id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
