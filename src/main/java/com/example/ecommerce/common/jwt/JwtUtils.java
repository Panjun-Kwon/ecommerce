package com.example.ecommerce.common.jwt;

import com.example.ecommerce.domain.member.entity.member.*;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.*;
import io.jsonwebtoken.security.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.security.*;
import java.util.*;

@Component
public class JwtUtils {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final long EXPIRATION_TIME = 1000L * 60 * 60;
    private final Key key;

    public JwtUtils(@Value("${jwt.secretKey}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(AuthMember authMember) {
        Date issuedAt = new Date();
        Date expiredAt = new Date(issuedAt.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .claim("id", authMember.getMember().getId())
                .claim("username", authMember.getMember().getUsername())
                .claim("role", authMember.getMember().getRole())
                .setIssuedAt(issuedAt)
                .setExpiration(expiredAt)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public AuthMember getAuth(String accessToken) {

        Claims claims = validateToken(accessToken);

        Long id = claims.get("id", Long.class);
        String username = claims.get("username", String.class);
        Role role = Role.valueOf(claims.get("role", String.class));

        Member member = new Member(id, username, role);

        return new AuthMember(member);
    }

    public Claims validateToken(String accessToken) {
        Claims claims = null;

        try {
            claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            System.out.println("너니 ? 1");
        } catch (UnsupportedJwtException e) {
            System.out.println("너니 ? 2");
        } catch (MalformedJwtException e) {
            System.out.println("너니 ? 3");
        }

        return claims;
    }

}
