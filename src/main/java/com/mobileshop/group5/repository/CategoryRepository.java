package com.mobileshop.group5.repository;

import com.mobileshop.group5.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findByCategoryId(@Param("categoryID")String catId);
    List<Category> findAll();
}
