package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SupplierRiskAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;
    private String alertType;
    private String alertMessage;
    private LocalDateTime alertDate = LocalDateTime.now();

    // Default constructor
    public SupplierRiskAlert() {}

    // Getters
    public Long getId() {
        return id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public String getAlertType() {
        return alertType;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public LocalDateTime getAlertDate() {
        return alertDate;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public void setAlertDate(LocalDateTime alertDate) {
        this.alertDate = alertDate;
    }
}
