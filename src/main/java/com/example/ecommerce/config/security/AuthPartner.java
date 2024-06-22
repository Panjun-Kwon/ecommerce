package com.example.ecommerce.config.security;

import com.example.ecommerce.domain.partner.entity.partner.*;
import io.jsonwebtoken.*;
import lombok.*;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;

import java.util.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthPartner implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private Role role;

    public static AuthPartner of(Partner partner) {
        AuthPartner authPartner = new AuthPartner();
        authPartner.id = partner.getId();
        authPartner.username = partner.getUsername();
        authPartner.password = partner.getPassword();
        authPartner.role = partner.getRole();
        return authPartner;
    }

    public static AuthPartner of(Claims claims) {
        AuthPartner authPartner = new AuthPartner();
        authPartner.id = claims.get("id", Long.class);
        authPartner.username = claims.get("username", String.class);
        authPartner.role = Role.valueOf(claims.get("role", String.class));
        return authPartner;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(() -> "ROLE_" + role);
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
