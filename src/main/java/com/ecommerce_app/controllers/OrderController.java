package com.ecommerce_app.controllers;

import com.ecommerce_app.dtos.api_response.ApiResponse;
import com.ecommerce_app.dtos.order.CreateOrder;
import com.ecommerce_app.dtos.order.OrderResponseDto;
import com.ecommerce_app.services.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@Data
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping(path = "/create")
    public ResponseEntity<ApiResponse<OrderResponseDto>> createOrder (@RequestBody CreateOrder createOrder) {
        OrderResponseDto order = orderService.createOrder(createOrder);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(
                        true,
                        "Order placed successfully !",
                        order
                )
        );
    }
}
