package com.mobileshop.group5.repository;

import com.mobileshop.group5.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductName(String productName);
    List<Product> findAll();
    Product findByProductId(@Param("productID") Integer productId);
}
