package com.productmicroservice.productmicroservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductValidationError extends RuntimeException {
    public ProductValidationError(String errors) {
        super(errors);
    }
}
