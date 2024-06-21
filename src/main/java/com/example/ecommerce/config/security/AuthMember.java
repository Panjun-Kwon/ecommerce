package com.example.ecommerce.config.security;

import com.example.ecommerce.domain.member.entity.member.*;
import io.jsonwebtoken.*;
import lombok.*;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;

import java.util.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthMember implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private Role role;

    public static AuthMember of(Member member) {
        AuthMember authMember = new AuthMember();
        authMember.id = member.getId();
        authMember.username = member.getUsername();
        authMember.password = member.getPassword();
        authMember.role = member.getRole();
        return authMember;
    }

    public static AuthMember of(Claims claims) {
        AuthMember authMember = new AuthMember();
        authMember.id = claims.get("id", Long.class);
        authMember.username = claims.get("username", String.class);
        authMember.role = Role.valueOf(claims.get("role", String.class));
        return authMember;
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
