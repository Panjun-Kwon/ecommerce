package com.example.ecommerce.domain.product.entity.product;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "products")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;
    private int unitPrice;
    private int stock;
    private Long partnerId;

    @Builder
    private Product(String name, int unitPrice, int stock, Long partnerId) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.partnerId = partnerId;
    }
}
