package com.example.ecommerce.domain.partner.entity.partner;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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

    @Column(unique = true, updatable = false)
    @NotNull
    private String username;
    @NotNull
    private String password;

    @Column(unique = true)
    @NotNull
    private String name;
    @Column(updatable = false)
    @Email
    private String email;
    private String phoneNum;
    @Embedded
    private Address address;

    @Builder
    public Partner(String username,
                   String password,
                   String name,
                   String email,
                   String phoneNum,
                   Address address) {

        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
    }
}
