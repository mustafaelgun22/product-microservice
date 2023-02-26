package com.productmicroservice.productmicroservice.Service;

import com.productmicroservice.productmicroservice.DTO.ProductDto;
import com.productmicroservice.productmicroservice.Exception.ProductNotFoundException;
import com.productmicroservice.productmicroservice.Model.Product;
import com.productmicroservice.productmicroservice.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product){
        return repository.save(product);
    }

    public List<ProductDto> getAllProducts(){
        return repository.findAll()
                .stream().map(x-> new ProductDto(x.getName(), x.getPrice()))
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id){
        return repository.findById(id)
                .map(product-> new ProductDto(product.getName(), product.getPrice()))
                .orElseThrow(()->new ProductNotFoundException("Product does not exists"));
    }
}
