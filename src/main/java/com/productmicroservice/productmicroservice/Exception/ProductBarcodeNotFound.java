package com.productmicroservice.productmicroservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductBarcodeNotFound extends RuntimeException{
    public ProductBarcodeNotFound(String m) {
        super(m);
    }
}
