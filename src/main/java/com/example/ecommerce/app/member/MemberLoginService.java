package com.example.ecommerce.app.member;

import com.example.ecommerce.common.jwt.*;
import com.example.ecommerce.config.security.*;
import com.example.ecommerce.domain.member.info.*;
import lombok.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@RequiredArgsConstructor
public class MemberLoginService {

    private final AuthenticationProvider memberAuthenticationProvider;
    private final JwtUtils jwtUtils;

    @Transactional
    public AccessTokenInfo login(String username, String password) {
        Authentication authentication = memberAuthenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        AuthMember authMember = (AuthMember) authentication.getPrincipal();
        String accessToken = jwtUtils.generateMemberAccessToken(authMember);
        return new AccessTokenInfo(authMember.getId(), accessToken);
    }
}
