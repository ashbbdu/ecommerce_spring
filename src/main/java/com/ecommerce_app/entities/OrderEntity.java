package com.ecommerce_app.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderEntity {
    private Long id;
    private BigDecimal totalAmount;
    private LocalDateTime orderedAt;
    private String status;
}
