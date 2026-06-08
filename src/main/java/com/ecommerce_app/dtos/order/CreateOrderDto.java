package com.ecommerce_app.dtos.order;

import java.math.BigDecimal;

public class CreateOrderDto {
    private Long customer_id;
    private Long product_id;
    private Integer quantity;
    private BigDecimal totalAmount;
    private String status;

}
