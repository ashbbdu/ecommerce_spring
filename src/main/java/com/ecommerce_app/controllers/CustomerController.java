package com.ecommerce_app.controllers;

import com.ecommerce_app.dtos.api_response.ApiResponse;
import com.ecommerce_app.dtos.customers.CreateCustomerDto;
import com.ecommerce_app.dtos.customers.CustomerResponseDto;
import com.ecommerce_app.services.CustomerService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@Data
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping(path = "/create")
    public ResponseEntity<ApiResponse<CustomerResponseDto>>
    createCustomer(
            @Valid
            @RequestBody CreateCustomerDto request
    ) {

        CustomerResponseDto customer =
                customerService.addCustomer(request);


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new ApiResponse<>(
                                true,
                                "Customer created successfully",
                                customer
                        )
                );
    }

}
