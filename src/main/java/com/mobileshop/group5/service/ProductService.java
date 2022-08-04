package com.mobileshop.group5.service;

import com.mobileshop.group5.model.Product;
import com.mobileshop.group5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return this.productRepository.findAll();
    }

    public List<Product> findByProductName(String productName){
        return this.productRepository.findByProductName(productName);
    }
    public List<Product> search(String productName){
        return  this.productRepository.search(productName);
    }

    public Product findByProductId(Integer productId){
        return this.productRepository.findByProductId(productId);
    }

    public Product save(Product product){
        return this.productRepository.save(product);
    }
}
