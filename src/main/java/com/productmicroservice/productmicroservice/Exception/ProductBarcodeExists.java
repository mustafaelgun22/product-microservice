package com.productmicroservice.productmicroservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ProductBarcodeExists extends RuntimeException{
    public ProductBarcodeExists(String m) {
        super(m);
    }
}
