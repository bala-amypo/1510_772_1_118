package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseOrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long poId;

    private Long supplierId;
    private String poNumber;
    private int quantity;
    private LocalDate issuedDate;
    private LocalDate promisedDeliveryDate;

    // Default constructor
    public PurchaseOrderRecord() {}

    // Getters
    public Long getPoId() {
        return poId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public LocalDate getPromisedDeliveryDate() {
        return promisedDeliveryDate;
    }

    // Setters
    public void setPoId(Long poId) {
        this.poId = poId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setPromisedDeliveryDate(LocalDate promisedDeliveryDate) {
        this.promisedDeliveryDate = promisedDeliveryDate;
    }
}
