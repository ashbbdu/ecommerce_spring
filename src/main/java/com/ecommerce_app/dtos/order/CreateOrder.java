package com.ecommerce_app.dtos.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrder {
    @NotNull(message = "Customer Id is required")
    private Long customerId;
    @Valid
    @Size(min = 1, message = "Order must contain at least one item")
    List<OrderItem> items;
}
