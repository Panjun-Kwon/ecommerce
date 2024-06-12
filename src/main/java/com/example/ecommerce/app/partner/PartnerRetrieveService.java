package com.example.ecommerce.app.partner;

import com.example.ecommerce.api.partner.dto.PartnerResponse;
import com.example.ecommerce.domain.partner.dto.PartnerInfo;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.partner.service.PartnerReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartnerRetrieveService {

    private final PartnerReader partnerReader;

    public PartnerResponse.PartnerList retrievePartnerList(Pageable pageable) {
        Page<Partner> partnerPage = partnerReader.getPartnerAll(pageable);

        List<PartnerInfo.PartnerList> infoList = partnerPage.stream()
                .map(partner -> PartnerInfo.PartnerList.of(partner))
                .collect(Collectors.toList());

        return PartnerResponse.PartnerList.builder()
                .partnerList(infoList)
                .currentElements(partnerPage.getNumberOfElements())
                .totalPages(partnerPage.getTotalPages())
                .totalElements(partnerPage.getTotalElements())
                .build();
    }

    public PartnerResponse.PartnerDetail retrievePartnerDetail(Long partnerId) {
        Partner partner = partnerReader.getPartner(partnerId);

        PartnerInfo.PartnerDetail info = PartnerInfo.PartnerDetail.of(partner);

        return PartnerResponse.PartnerDetail.builder()
                .partner(info)
                .build();
    }
}
