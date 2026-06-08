package com.ecommerce_app.entities;


import jakarta.persistence.*;


import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers" , uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_customer_email",
                columnNames = "email"
        ),
        @UniqueConstraint(
                name = "uk_customer_phone",
                columnNames = "phone"
        )
})
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false , unique = true)
    private String email;
    @Column(nullable = false , unique = true)
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_profile_id")
    private CustomerProfileEntity customer_profile;

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;

}
