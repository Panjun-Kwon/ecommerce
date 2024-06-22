package com.example.ecommerce.app.partner;

import com.example.ecommerce.api.partner.request.*;
import com.example.ecommerce.api.partner.response.*;
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
public class PartnerLoginService {

    private final AuthenticationProvider partnerAuthenticationProvider;
    private final JwtUtils jwtUtils;

    public AccessTokenResponse login(LoginRequest request) {

        Authentication authentication = partnerAuthenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        AuthPartner authPartner = (AuthPartner) authentication.getPrincipal();
        Long partnerId = authPartner.getId();
        String accessToken = jwtUtils.generatePartnerAccessToken(authPartner);

        return new AccessTokenResponse(partnerId, accessToken);
    }
}
