package com.example.ecommerce.infra.partner;

import com.example.ecommerce.common.exception.*;
import com.example.ecommerce.domain.partner.entity.partner.*;
import com.example.ecommerce.domain.partner.service.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

@Component
@RequiredArgsConstructor
public class PartnerReaderImpl implements PartnerReader {

    private final PartnerRepository partnerRepository;

    @Override
    public Partner getPartner(Long partnerId) {
        return partnerRepository.findById(partnerId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_ENTITY,
                        String.format("해당 파트너(%d)를 찾을 수 없음", partnerId)));
    }

    @Override
    public Page<Partner> getPartnerAll(Pageable pageable) {
        return partnerRepository.findAll(pageable);
    }

    @Override
    public boolean existPartner(Long partnerId) {
        return partnerRepository.existsById(partnerId);
    }

    @Override
    public Partner getPartnerByUsername(String username) {
        return partnerRepository.findByUsername(username)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_ENTITY,
                        String.format("해당 파트너(%s)를 찾을 수 없음", username)));
    }
}
