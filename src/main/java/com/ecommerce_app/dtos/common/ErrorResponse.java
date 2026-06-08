package com.ecommerce_app.dtos.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private boolean success;

    private String message;

    private Object errors;

    private LocalDateTime timestamp;
}