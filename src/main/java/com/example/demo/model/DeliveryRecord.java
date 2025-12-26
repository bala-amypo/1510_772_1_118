package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_records")
public class DeliveryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long supplierId;

    @Column(nullable = false)
    private Integer delayDays;

    private LocalDateTime createdAt = LocalDateTime.now();

    public DeliveryRecord() {}

    public DeliveryRecord(Long supplierId, Integer delayDays) {
        this.supplierId = supplierId;
        this.delayDays = delayDays;
    }

    public Long getId() {
        return id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(Integer delayDays) {
        this.delayDays = delayDays;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
