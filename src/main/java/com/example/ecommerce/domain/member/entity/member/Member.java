package com.example.ecommerce.domain.member.entity.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.crypto.password.*;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor
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
    @Embedded
    private Profile profile;

    @Builder
    public Member(String username,
                  String password,
                  Profile profile) {

        this.role = Role.MEMBER;
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    public void modifyPassword(String password) {
        this.password = password;
    }

    public void modifyEmail(String email) {
        this.profile.modifyEmail(email);
    }

    public void modifyPhoneNum(String phoneNum) {
        this.profile.modifyPhoneNum(phoneNum);
    }

    public void modifyAddress(Address address) {
        this.profile.modifyAddress(address);
    }
}
