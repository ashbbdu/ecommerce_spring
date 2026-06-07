package com.ecommerce_app.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class CategoryEntity {
    private Long id;
    private String categoryName;
    private String description;


}
