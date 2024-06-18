package com.example.ecommerce.domain.member.entity.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "members")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true, updatable = false)
    @NotNull
    private String username;
    @NotNull
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(updatable = false)
    @NotNull
    private String name;
    @Email
    private String email;
    private String phoneNum;
    @Embedded
    private Address address;

    public Member(Long id, @NotNull String username, Role role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    @Builder
    public Member(String username,
                  String password,
                  String name,
                  String email,
                  String phoneNum,
                  Address address) {

        this.username = username;
        this.password = password;
        this.role = Role.MEMBER;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
    }
}
