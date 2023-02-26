package com.productmicroservice.productmicroservice.Controller;

import com.productmicroservice.productmicroservice.DTO.ProductDetailDto;
import com.productmicroservice.productmicroservice.DTO.ProductDto;
import com.productmicroservice.productmicroservice.Model.Product;
import com.productmicroservice.productmicroservice.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
@Validated
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/create/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
            productService.createProduct(product);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
            return ResponseEntity.created(location).build();
    }
    @GetMapping(value = "/get_all_products/")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(value = "/{id}/")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/barcode/{barcode}/")
    public ResponseEntity<ProductDetailDto> getProductByBarcode(@PathVariable Long barcode){
        return ResponseEntity.ok(productService.getProductByBarcode(barcode));
    }

}
