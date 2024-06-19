package com.example.ecommerce.domain.member.entity.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

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
    @Enumerated
    private Profile profile;
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
                  Profile profile,
                  Address address) {

        this.username = username;
        this.password = password;
        this.role = Role.MEMBER;
        this.profile = profile;
        this.address = address;
    }
}
