package com.productmicroservice.productmicroservice.Exception;

public class ProductBarcodeNotFound extends RuntimeException{
    public ProductBarcodeNotFound(String m) {
        super(m);
    }
}
