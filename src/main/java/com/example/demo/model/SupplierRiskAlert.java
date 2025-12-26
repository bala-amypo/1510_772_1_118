package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Entity
public class SupplierRiskAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean resolved;

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public boolean getResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
