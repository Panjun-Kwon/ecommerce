package com.example.ecommerce.app.partner;

import com.example.ecommerce.api.partner.response.*;
import com.example.ecommerce.domain.partner.entity.partner.*;
import com.example.ecommerce.domain.partner.service.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

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

        RetrievePartnerList.PageInfo pageInfo = makePageInfo(partnerPage);

        return new RetrievePartnerList(partnerInfoList, pageInfo);
    }

    private static RetrievePartnerList.PageInfo makePageInfo(Page<Partner> partnerPage) {
        return RetrievePartnerList.PageInfo.builder()
                .currentElements(partnerPage.getNumberOfElements())
                .totalPages(partnerPage.getTotalPages())
                .totalElements(partnerPage.getTotalElements())
                .build();
    }
}
