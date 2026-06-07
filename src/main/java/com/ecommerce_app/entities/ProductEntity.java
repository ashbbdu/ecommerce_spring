package com.ecommerce_app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer stockQuantity;
    @Column(nullable = false)
    private String brand;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;


    @OneToMany(mappedBy = "product")
    private List<OrderItemEntity> orderItems;

}
