package com.example.ecommerce.domain.product.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Registrant {
    @Column(name = "registrant_id", updatable = false)
    @NotNull
    private Long partnerId;
    @Column(name = "registrant_name", updatable = false)
    @NotNull
    private String name;
}
