package com.mobileshop.group5.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Orders", schema = "dbo")
public class Order {
    private int orderId;
    private Timestamp date;
    private double total;
    private String userId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "total", nullable = false, precision = 0)
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId &&
                Double.compare(order.total, total) == 0 &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, date, total);
    }

    @Basic
    @Column(name = "userID", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
