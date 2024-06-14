package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.domain.partner.entity.partner.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PartnerReader {
    Partner getPartner(Long partnerId);

    Page<Partner> getPartnerAll(Pageable pageable);

    boolean existPartner(Long partnerId);
}
