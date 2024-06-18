package com.example.ecommerce.common.jwt;

import com.example.ecommerce.domain.member.entity.member.AuthMember;
import com.example.ecommerce.domain.member.entity.member.Member;
import com.example.ecommerce.domain.member.entity.member.Role;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private final Key key;

    public JwtUtils(@Value("${jwt.secretKey}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(AuthMember authMember) {
        Date issuedAt = new Date();
        Date expiredAt = new Date(issuedAt.getTime() + 1000L * 60 * 60);

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
