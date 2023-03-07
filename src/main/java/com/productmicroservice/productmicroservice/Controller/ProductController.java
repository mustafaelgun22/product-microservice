package com.productmicroservice.productmicroservice.Controller;

import com.productmicroservice.productmicroservice.DTO.ProductDetailDto;
import com.productmicroservice.productmicroservice.DTO.ProductDto;
import com.productmicroservice.productmicroservice.Model.Product;
import com.productmicroservice.productmicroservice.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
@Validated
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/create/")
    public ResponseEntity<ProductDto> createProduct(@RequestBody Product product){
            productService.getProductByBarcodeCheck(product.getBarcode());
            Product created_product=productService.createProduct(product);
            return ResponseEntity.created(null)
                .body(new ProductDto(
                        created_product.getName(),
                        created_product.getPrice(),
                        created_product.getBarcode()));
    }
    @GetMapping(value = "/get_all_products/")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(value = "/{id}/")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        logger.info("Product requested by id"+id);
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/barcode/{barcode}/")
    public ResponseEntity<ProductDetailDto> getProductByBarcode(@PathVariable Long barcode){
        return ResponseEntity.ok(productService.getProductByBarcode(barcode));
    }

}
