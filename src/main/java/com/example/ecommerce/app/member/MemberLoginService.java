package com.example.ecommerce.app.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.common.jwt.*;
import com.example.ecommerce.config.security.*;
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

    private final AuthenticationProvider memberAuthenticationProvider;
    private final JwtUtils jwtUtils;

    public AccessTokenResponse login(LoginRequest request) {

        Authentication authentication = memberAuthenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        AuthMember authMember = (AuthMember) authentication.getPrincipal();
        Long memberId = authMember.getId();
        String accessToken = jwtUtils.generateMemberAccessToken(authMember);

        return new AccessTokenResponse(memberId, accessToken);
    }
}
