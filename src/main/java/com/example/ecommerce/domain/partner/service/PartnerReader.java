package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.domain.partner.entity.partner.*;
import org.springframework.data.domain.*;

public interface PartnerReader {
    Partner getPartner(Long partnerId);

    Page<Partner> getPartnerAll(Pageable pageable);

    boolean existPartner(Long partnerId);

    Partner getPartnerByUsername(String username);
}
