package com.productmicroservice.productmicroservice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="price",nullable = false)
    private Double price;

    @Column(name="barcode",unique = true,nullable = false)
    private Long barcode;

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public Long getBarcode() {
        return barcode;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
