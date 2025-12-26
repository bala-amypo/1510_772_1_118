package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseOrderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private LocalDate orderDate;
    private double amount;

    // Getters
    public String getOrderNumber() { return orderNumber; }
    public LocalDate getOrderDate() { return orderDate; }
    public double getAmount() { return amount; }

    // Setters
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
    public void setAmount(double amount) { this.amount = amount; }
}
