package com.example.ecommerce.domain.partner.entity.partner;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.crypto.password.*;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "partners")
@Getter
@NoArgsConstructor
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
    @Enumerated
    private Role role;
    @Embedded
    private Profile profile;


    @Builder
    public Partner(String username,
                   String password,
                   Profile profile) {

        this.role = Role.PARTNER;
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
