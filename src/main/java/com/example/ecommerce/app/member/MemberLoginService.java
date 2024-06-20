package com.example.ecommerce.app.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.common.jwt.*;
import com.example.ecommerce.domain.member.entity.member.*;
import lombok.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberLoginService {

    private final AuthenticationProvider authenticationProvider;
    private final JwtUtils jwtUtils;

    public AccessTokenResponse login(LoginRequest request) {

        Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        AuthMember authMember = (AuthMember) authentication.getPrincipal();
        String accessToken = jwtUtils.generateAccessToken(authMember);

        return new AccessTokenResponse(authMember.getMember().getId(), accessToken);
    }
}
