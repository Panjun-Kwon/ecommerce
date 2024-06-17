package com.example.ecommerce.domain.order.entity.order;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Receiver {
    @Column(name = "receiver_name")
    @NotNull
    private String name;
    @Column(name = "receiver_phone_num")
    @NotNull
    private String phoneNum;
}
