package com.ecommerce_app.repositories;

import com.ecommerce_app.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity , Long> {
}
