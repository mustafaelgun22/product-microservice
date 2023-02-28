package com.productmicroservice.productmicroservice.DTO;

public class ProductDto {
    private String  name;
    private double price;
    private Long barcode;

    public ProductDto(String name, double price,Long barcode) {
        this.name = name;
        this.price = price;
        this.barcode=barcode;
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

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }
}
