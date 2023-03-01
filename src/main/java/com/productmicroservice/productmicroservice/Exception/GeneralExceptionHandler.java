package com.productmicroservice.productmicroservice.Exception;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handle(ProductNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductBarcodeNotFound.class)
    public ResponseEntity<?> handle(ProductBarcodeNotFound exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductBarcodeExists.class)
    public ResponseEntity<?> handle(ProductBarcodeExists exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<?> handle(PropertyValueException exception){
        if(exception.getPropertyName()=="price")
            return new ResponseEntity<>("price is missing",HttpStatus.BAD_REQUEST);
        else if (exception.getPropertyName()=="barcode") {
            return new ResponseEntity<>("barcode is missing",HttpStatus.BAD_REQUEST);
        } else if (exception.getPropertyName()=="name") {
            return new ResponseEntity<>("name is missing",HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
