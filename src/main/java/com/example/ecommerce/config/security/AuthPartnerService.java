package com.example.ecommerce.config.security;

import com.example.ecommerce.domain.partner.entity.partner.*;
import com.example.ecommerce.domain.partner.service.*;
import lombok.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class AuthPartnerService implements UserDetailsService {

    private final PartnerReader partnerReader;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Partner partner = partnerReader.getPartnerByUsername(username);
        return AuthPartner.of(partner);
    }
}
