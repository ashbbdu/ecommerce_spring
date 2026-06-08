package com.ecommerce_app.repositories;

import com.ecommerce_app.entities.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity  , Long> {

}
