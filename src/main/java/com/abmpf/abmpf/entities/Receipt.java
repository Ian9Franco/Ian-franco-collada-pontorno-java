package com.abmpf.abmpf.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private LocalDateTime createdAt;
    private double total;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReceiptDetail> details;

    // Constructors, getters, and setters
    public Receipt() {}

    public Receipt(Client client, LocalDateTime createdAt, double total) {
        this.client = client;
        this.createdAt = createdAt;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<ReceiptDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ReceiptDetail> details) {
        this.details = details;
    }
}
