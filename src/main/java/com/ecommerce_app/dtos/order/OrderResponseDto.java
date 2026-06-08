package com.ecommerce_app.dtos.order;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class OrderResponseDto {
    private Long orderId;

    private BigDecimal totalAmount;

    private String status;

    private LocalDateTime orderedAt;
}
