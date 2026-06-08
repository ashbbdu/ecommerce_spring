package com.ecommerce_app.repositories;

import com.ecommerce_app.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity , Long> {
}
