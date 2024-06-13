package com.example.ecommerce.infra.partner;

import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.common.exception.ErrorCode;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.partner.service.PartnerReader;
import com.example.ecommerce.domain.partner.service.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

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
}
