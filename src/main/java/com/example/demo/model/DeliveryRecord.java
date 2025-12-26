package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DeliveryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    private Long poId;
    private LocalDate actualDeliveryDate;

    // Getters and Setters
    public Long getDeliveryId() {
        return deliveryId;
    }
    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getPoId() {
        return poId;
    }
    public void setPoId(Long poId) {
        this.poId = poId;
    }

    public LocalDate getActualDeliveryDate() {
        return actualDeliveryDate;
    }
    public void setActualDeliveryDate(LocalDate actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }
}
