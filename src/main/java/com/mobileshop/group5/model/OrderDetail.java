package com.mobileshop.group5.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OrderDetail", schema = "dbo")
public class OrderDetail {
    private int orderDetailId;
    private int orderId;
    private double price;
    private int quantity;
    private Order orderByOrderDetailId;
    private int productId;

    @Id
    @Column(name = "orderDetailID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    @Basic
    @Column(name = "orderID", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return orderDetailId == that.orderDetailId &&
                orderId == that.orderId &&
                Double.compare(that.price, price) == 0 &&
                quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDetailId, orderId, price, quantity);
    }

    @OneToOne
    @JoinColumn(name = "orderDetailID", referencedColumnName = "orderID", nullable = false)
    public Order getOrderByOrderDetailId() {
        return orderByOrderDetailId;
    }

    public void setOrderByOrderDetailId(Order orderByOrderDetailId) {
        this.orderByOrderDetailId = orderByOrderDetailId;
    }

    @Basic
    @Column(name = "productID", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
