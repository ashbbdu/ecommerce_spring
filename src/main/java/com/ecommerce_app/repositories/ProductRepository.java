package com.ecommerce_app.repositories;

import com.ecommerce_app.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity , Long> {
}
