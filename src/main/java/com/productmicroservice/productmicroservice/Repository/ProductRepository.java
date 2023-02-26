package com.productmicroservice.productmicroservice.Repository;

import com.productmicroservice.productmicroservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
