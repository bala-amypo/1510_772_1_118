package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DeliveryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deliveryNumber;
    private LocalDate deliveryDate;
    private boolean delivered;

    // Default constructor
    public DeliveryRecord() {}

    // Getters and Setters
    public Long getId() { return id; }

    public String getDeliveryNumber() { return deliveryNumber; }
    public void setDeliveryNumber(String deliveryNumber) { this.deliveryNumber = deliveryNumber; }

    public LocalDate getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }

    public boolean getDelivered() { return delivered; }
    public void setDelivered(boolean delivered) { this.delivered = delivered; }
}
