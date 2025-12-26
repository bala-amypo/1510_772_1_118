package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SupplierRiskAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;
    private String message;
    private boolean resolved;

    public Long getId() { return id; }

    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean getResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
