package com.mobileshop.group5.service;

import com.mobileshop.group5.model.Category;
import com.mobileshop.group5.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(String id){
        return categoryRepository.findByCategoryId(id);
    }
}
