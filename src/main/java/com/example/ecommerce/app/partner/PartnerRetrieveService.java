package com.example.ecommerce.app.partner;

import com.example.ecommerce.api.partner.response.RetrievePartnerDetail;
import com.example.ecommerce.api.partner.response.RetrievePartnerList;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.partner.service.PartnerMapper;
import com.example.ecommerce.domain.partner.service.PartnerReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnerRetrieveService {

    private final PartnerReader partnerReader;
    private final PartnerMapper partnerMapper;

    public RetrievePartnerDetail retrievePartnerDetail(Long partnerId) {
        Partner partner = partnerReader.getPartner(partnerId);
        RetrievePartnerDetail.PartnerInfo partnerInfo = partnerMapper.retrieveDetailOf(partner);

        return new RetrievePartnerDetail(partnerInfo);
    }

    public RetrievePartnerList retrievePartnerList(Pageable pageable) {
        Page<Partner> partnerPage = partnerReader.getPartnerAll(pageable);
        List<RetrievePartnerList.PartnerInfo> partnerInfoList = partnerMapper.retrieveListOf(partnerPage.getContent());

        RetrievePartnerList.PageInfo pageInfo = meakePageInfo(partnerPage);

        return new RetrievePartnerList(partnerInfoList, pageInfo);
    }

    private static RetrievePartnerList.PageInfo meakePageInfo(Page<Partner> partnerPage) {
        return RetrievePartnerList.PageInfo.builder()
                .currentElements(partnerPage.getNumberOfElements())
                .totalPages(partnerPage.getTotalPages())
                .totalElements(partnerPage.getTotalElements())
                .build();
    }
}
