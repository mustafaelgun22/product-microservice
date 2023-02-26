package com.productmicroservice.productmicroservice.Exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String m) {
         super(m);
    }
}
