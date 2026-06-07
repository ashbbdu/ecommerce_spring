package com.ecommerce_app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal totalAmount;
    @Column(nullable = false)
    private LocalDateTime orderedAt;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToOne(mappedBy = "order")
    private PaymentEntity payment;

    @OneToMany(mappedBy = "order")
    private Set<OrderItemEntity> orders;

}
