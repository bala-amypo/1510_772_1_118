
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
    private int delivered;

    // Getters
    public String getDeliveryNumber() { return deliveryNumber; }
    public LocalDate getDeliveryDate() { return deliveryDate; }
    public int getDelivered() { return delivered; }

    // Setters
    public void setDeliveryNumber(String deliveryNumber) { this.deliveryNumber = deliveryNumber; }
    public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }
    public void setDelivered(int delivered) { this.delivered = delivered; }
}
