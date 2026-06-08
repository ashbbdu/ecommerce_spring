package com.ecommerce_app.dtos.products;



import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long id;

    private String productName;

    private BigDecimal price;

    private Integer stockQuantity;

    private String brand;

    private Long categoryId;

    private String categoryName;
}