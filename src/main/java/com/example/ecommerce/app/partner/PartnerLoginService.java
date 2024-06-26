package com.example.ecommerce.app.partner;

import com.example.ecommerce.common.jwt.*;
import com.example.ecommerce.config.security.*;
import com.example.ecommerce.domain.partner.info.*;
import lombok.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
@RequiredArgsConstructor
public class PartnerLoginService {

    private final AuthenticationProvider partnerAuthenticationProvider;
    private final JwtUtils jwtUtils;

    public AccessTokenInfo login(String username, String password) {
        Authentication authentication = partnerAuthenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        AuthPartner authPartner = (AuthPartner) authentication.getPrincipal();
        String accessToken = jwtUtils.generatePartnerAccessToken(authPartner);
        return new AccessTokenInfo(authPartner.getId(), accessToken);
    }
}
