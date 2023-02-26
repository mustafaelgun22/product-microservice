package com.productmicroservice.productmicroservice.DTO;

import com.productmicroservice.productmicroservice.Model.Product;

public class ProductDto {
    private String  name;
    private double price;

    public ProductDto(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
