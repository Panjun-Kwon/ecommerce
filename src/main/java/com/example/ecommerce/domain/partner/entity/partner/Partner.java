package com.example.ecommerce.domain.partner.entity.partner;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

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
    @Embedded
    private Profile profile;
    @Embedded
    private Address address;

    @Builder
    public Partner(String username,
                   String password,
                   Profile profile,
                   Address address) {

        this.username = username;
        this.password = password;
        this.profile = profile;
        this.address = address;
    }
}
