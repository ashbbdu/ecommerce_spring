package com.ecommerce_app.controllers;

import com.ecommerce_app.dtos.api_response.ApiResponse;
import com.ecommerce_app.dtos.products.ProductDto;
import com.ecommerce_app.dtos.products.ProductResponse;
import com.ecommerce_app.entities.ProductEntity;
import com.ecommerce_app.services.ProductService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Data
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(path = "/add")
    public ResponseEntity<ApiResponse<ProductResponse>> createProduct(@RequestBody @Valid ProductDto productDto) {
        ProductResponse product = productService.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(
                        true,
                        "Product added successfully !",
                        product
                )
        );
    }

    @GetMapping(path = "/list/{pageNumber}")
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAllProducts (@PathVariable Long pageNumber) {
        List<ProductResponse> products = productService.getAllProducts();

        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(
                        true,
                        "Products fetched successfully !",
                        products
                )
        );
    }
}
