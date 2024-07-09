package com.abmpf.abmpf.entities;

import jakarta.persistence.*;
import lombok.Getter;


import java.util.List;

@Getter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String lastname;
    private String docnumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receipt> receipts;

    // Constructors, getters, and setters
    public Client() {}

    public Client(String name, String lastname, String docnumber) {
        this.name = name;
        this.lastname = lastname;
        this.docnumber = docnumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }
}
