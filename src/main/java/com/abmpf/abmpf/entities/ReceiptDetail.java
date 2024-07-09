package com.abmpf.abmpf.entities;

import jakarta.persistence.*;

@Entity
public class ReceiptDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int amount;
    private double price;

    // Constructors, getters, and setters
    public ReceiptDetail() {}

    public ReceiptDetail(Receipt receipt, Product product, int amount, double price) {
        this.receipt = receipt;
        this.product = product;
        this.amount = amount;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculateTotal() {
        return this.price * this.amount;
    }
}
