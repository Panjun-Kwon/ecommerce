package com.example.ecommerce.infra.partner;

import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.partner.service.PartnerRepository;
import com.example.ecommerce.domain.partner.service.PartnerStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartnerStoreImpl implements PartnerStore {

    private final PartnerRepository partnerRepository;

    @Override
    public Partner store(Partner initPartner) {
        return partnerRepository.save(initPartner);
    }
}
