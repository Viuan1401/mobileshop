package com.mobileshop.group5.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Product")
public class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;
    private String description;
    private String manufacturer;
    private String condition;
    private String image;
    private Category categoryByCategoryId;

    @Id
    @Column(name = "productID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "productName", nullable = false, length = 50)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 2147483647)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "manufacturer", nullable = false, length = 50)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "condition", nullable = false, length = 50)
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 2147483647)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId &&
                Double.compare(product.price, price) == 0 &&
                quantity == product.quantity &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(description, product.description) &&
                Objects.equals(manufacturer, product.manufacturer) &&
                Objects.equals(condition, product.condition) &&
                Objects.equals(image, product.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price, quantity, description, manufacturer, condition, image);
    }

    @ManyToOne
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID", nullable = false)
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
