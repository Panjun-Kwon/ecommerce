package com.example.ecommerce.app.member;

import com.example.ecommerce.api.member.request.LoginRequest;
import com.example.ecommerce.common.jwt.JwtUtils;
import com.example.ecommerce.domain.member.entity.member.AuthMember;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberLoginService {

    private final AuthenticationProvider authenticationProvider;
    private final JwtUtils jwtUtils;

    public String login(LoginRequest request) {
        Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.generateAccessToken((AuthMember) authentication.getPrincipal());

        return accessToken;
    }
}
