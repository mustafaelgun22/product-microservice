package com.productmicroservice.productmicroservice.Service;

import com.productmicroservice.productmicroservice.Model.Product;
import com.productmicroservice.productmicroservice.Repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create_product(Product product){
        return repository.save(product);
    }
}
