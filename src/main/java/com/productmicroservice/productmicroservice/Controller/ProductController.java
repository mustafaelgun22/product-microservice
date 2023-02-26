package com.productmicroservice.productmicroservice.Controller;

import com.productmicroservice.productmicroservice.Model.Product;
import com.productmicroservice.productmicroservice.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/create/")
    public ResponseEntity<Product> create_product(@RequestBody Product product){
            productService.create_product(product);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
            return ResponseEntity.created(location).build();
    }
}
