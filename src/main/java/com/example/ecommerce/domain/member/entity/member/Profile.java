package com.example.ecommerce.domain.member.entity.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {
    @Column(updatable = false)
    @NotNull
    private String name;
    @Email
    private String email;
    private String phoneNum;

    public void modify(String email, String phoneNum) {
        modifyEmail(email);
        modifyPhoneNum(phoneNum);
    }

    public void modifyEmail(String email) {
        this.email = email;
    }

    public void modifyPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
