package com.productmicroservice.productmicroservice.Service;

import com.productmicroservice.productmicroservice.DTO.ProductDetailDto;
import com.productmicroservice.productmicroservice.DTO.ProductDto;
import com.productmicroservice.productmicroservice.Exception.ProductBarcodeExists;
import com.productmicroservice.productmicroservice.Exception.ProductBarcodeNotFound;
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
                .stream().map(x-> new ProductDto(
                        x.getName(),
                        x.getPrice(),
                        x.getBarcode()))
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id){
        return repository.findById(id)
                .map(product-> new ProductDto(
                        product.getName(),
                        product.getPrice(),
                        product.getBarcode()))
                .orElseThrow(()->new ProductNotFoundException("Product does not exists"));
    }

    public ProductDetailDto getProductByBarcode(Long barcode){
        return repository.findByBarcode(barcode).map(x-> new ProductDetailDto(x.getId(), x.getBarcode()))
                .orElseThrow(()-> new ProductBarcodeNotFound("Product barcode does not exists"));
    }

    public void getProductByBarcodeCheck(Long barcode){
        if(!repository.findByBarcode(barcode).isEmpty()){
            throw new ProductBarcodeExists("There is a product in this barcode");
        }
    }
}
