package com.example.ecommerce.common.jwt;

import com.example.ecommerce.config.security.*;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.*;
import io.jsonwebtoken.security.*;
import jakarta.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;

import java.security.*;
import java.util.*;

@Component
public class JwtUtils {

    @Value("${jwt.token-header}")
    public String tokenHeader;
    @Value("${jwt.token-prefix}")
    public String tokenPrefix;
    @Value("${jwt.secret-key}")
    private String secretKey;
    @Value("${jwt.expiration-time}")
    private Long expirationTime;
    private Key key;

    @PostConstruct
    public void init() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateMemberAccessToken(AuthMember authMember) {
        Date issuedAt = new Date();
        Date expiredAt = new Date(issuedAt.getTime() + expirationTime);

        return Jwts.builder()
                .claim("id", authMember.getId())
                .claim("username", authMember.getUsername())
                .claim("role", authMember.getRole())
                .setIssuedAt(issuedAt)
                .setExpiration(expiredAt)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String generatePartnerAccessToken(AuthPartner authPartner) {
        Date issuedAt = new Date();
        Date expiredAt = new Date(issuedAt.getTime() + expirationTime);

        return Jwts.builder()
                .claim("id", authPartner.getId())
                .claim("username", authPartner.getUsername())
                .claim("role", authPartner.getRole())
                .setIssuedAt(issuedAt)
                .setExpiration(expiredAt)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public AuthMember getAuthMember(String accessToken) {
        Claims claims = validateAccessToken(accessToken);
        return AuthMember.of(claims);
    }

    public AuthPartner getAuthPartner(String accessToken) {
        Claims claims = validateAccessToken(accessToken);
        return AuthPartner.of(claims);
    }

    public String getAccessToken(String token) {
        String accessToken = null;
        if (StringUtils.hasText(token) && token.startsWith(tokenPrefix)) {
            accessToken = token.replace(tokenPrefix, "");
        }
        return accessToken;
    }

    public Claims validateAccessToken(String accessToken) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(accessToken)
                .getBody();
    }
}
