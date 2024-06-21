package com.example.ecommerce.domain.partner.entity.partner;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Column(unique = true, updatable = false)
    @NotNull
    private String name;
    @Email
    private String email;
    private String phoneNum;

    public void modifyEmail(String email) {
        this.email = email;
    }

    public void modifyPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
