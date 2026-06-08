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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/{customerId}")
    public ResponseEntity<ApiResponse<CustomerResponseDto>> getCustomerById (@PathVariable Long customerId) {
        CustomerResponseDto customer = customerService.getCustomerById(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(
                        true,
                        "Customer fetched successfully",
                        customer
                )
        );
    }

    @GetMapping(path = "/list")
    public ResponseEntity<ApiResponse<List<CustomerResponseDto>>> getALlCustomers () {
        List<CustomerResponseDto> customers = customerService.getAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(
                        true,
                        "Customers fetched successfully",
                        customers
                )
        );
    }

}
