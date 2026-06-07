package com.ecommerce_app.entities;


import jakarta.persistence.*;


import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "customer_profile_id")
    private CustomerProfileEntity customer_profile;
}
