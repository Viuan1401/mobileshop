package com.mobileshop.group5.repository;

import com.mobileshop.group5.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}