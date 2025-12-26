package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SupplierRiskAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId; // added this field
    private String message;

    // Default constructor
    public SupplierRiskAlert() {}

    // Getters and Setters
    public Long getId() { return id; }

    public Long getSupplierId() { return supplierId; }  // added getter
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; } // setter

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
