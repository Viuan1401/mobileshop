package com.mobileshop.group5.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Category")
public class Category {
    private String categoryId;
    private String categoryName;

    @Id
    @Column(name = "categoryID", nullable = false, length = 10)
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "categoryName", nullable = false, length = 50)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) &&
                Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName);
    }
}
