package com.productmicroservice.productmicroservice.DTO;

public class ProductDetailDto {
    private Long id;
    private Long  barcode;

    public ProductDetailDto(Long id, Long barcode) {
        this.id = id;
        this.barcode = barcode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public Long getId() {
        return id;
    }

    public Long getBarcode() {
        return barcode;
    }
}
