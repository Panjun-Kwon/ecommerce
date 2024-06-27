package com.example.ecommerce.domain.member.entity.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Column(updatable = false)
    @NotNull
    private String name;
    @Email
    private String email;
    private String phoneNum;
    @Embedded
    private Address address;

    public void modifyEmail(String email) {
        this.email = email;
    }

    public void modifyPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void modifyAddress(Address address) {
        this.address = address;
    }
}
