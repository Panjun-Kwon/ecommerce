package com.example.ecommerce.domain.partner.entity.partner;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "partners")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Partner {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "partner_id")
    private Long id;

    private String name;

    @Builder
    private Partner(String name) {
        this.name = name;
    }
}
