package com.ecommerce_app.services;

import com.ecommerce_app.dtos.products.ProductDto;
import com.ecommerce_app.dtos.products.ProductResponse;
import com.ecommerce_app.entities.CategoryEntity;
import com.ecommerce_app.entities.ProductEntity;
import com.ecommerce_app.repositories.CategoryRepository;
import com.ecommerce_app.repositories.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Data
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public ProductResponse createProduct(ProductDto productDto) {
        CategoryEntity category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found !"));

        ProductEntity product = ProductEntity.builder()
                .productName(productDto.getProductName())
                .price(productDto.getPrice())
                .stockQuantity(productDto.getStockQuantity())
                .brand(productDto.getBrand())
                .category(category).build();

        productRepository.save(product);

        return ProductResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .brand(product.getBrand())
                .categoryId(category.getId())
                .categoryName(category.getCategoryName())
                .build();

    }
}
