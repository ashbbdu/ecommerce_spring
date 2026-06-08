package com.ecommerce_app.repositories;

import com.ecommerce_app.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity , Long> {
}
