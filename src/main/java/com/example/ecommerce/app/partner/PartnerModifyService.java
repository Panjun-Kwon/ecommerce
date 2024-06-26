package com.example.ecommerce.app.partner;

import com.example.ecommerce.domain.partner.command.*;
import com.example.ecommerce.domain.partner.entity.partner.*;
import com.example.ecommerce.domain.partner.service.*;
import lombok.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@RequiredArgsConstructor
public class PartnerModifyService {

    private final PartnerReader partnerReader;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void modifyPassword(Long partnerId, String password) {
        Partner partner = partnerReader.getPartner(partnerId);
        partner.modifyPassword(password);
        partner.encodePassword(passwordEncoder);
    }

    @Transactional
    public void modifyEmail(Long partnerId, String email) {
        Partner partner = partnerReader.getPartner(partnerId);
        partner.modifyEmail(email);
    }

    @Transactional
    public void modifyPhoneNum(Long partnerId, String phoneNum) {
        Partner partner = partnerReader.getPartner(partnerId);
        partner.modifyPhoneNum(phoneNum);
    }

    @Transactional
    public void modifyAddress(Long partnerId, AddressCommand addressCommand) {
        Partner partner = partnerReader.getPartner(partnerId);
        partner.modifyAddress(addressCommand.toAddress());
    }
}
