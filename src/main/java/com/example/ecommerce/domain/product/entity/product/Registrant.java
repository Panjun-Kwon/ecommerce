package com.example.ecommerce.domain.product.entity.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Registrant {
    @Column(name = "registrant_id", updatable = false)
    @NotNull
    private Long partnerId;
    @Column(name = "registrant_name", updatable = false)
    @NotNull
    private String name;
}
