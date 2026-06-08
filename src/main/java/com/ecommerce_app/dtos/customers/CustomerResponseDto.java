package com.ecommerce_app.dtos.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto {
    private Long id;


    private String name;

    private String email;

    private String phone;
}
