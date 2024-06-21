package com.example.ecommerce.infra.partner;

import com.example.ecommerce.api.partner.response.*;
import com.example.ecommerce.domain.partner.entity.partner.*;
import com.example.ecommerce.domain.partner.service.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class PartnerMapperImpl implements PartnerMapper {
    @Override
    public RetrievePartnerDetail.PartnerInfo retrieveDetailOf(Partner partner) {
        RetrievePartnerDetail.PartnerInfo partnerInfo = RetrievePartnerDetail.PartnerInfo.builder()
                .id(partner.getId())
                .name(partner.getProfile().getName())
                .build();

        return partnerInfo;
    }

    @Override
    public List<RetrievePartnerList.PartnerInfo> retrieveListOf(List<Partner> partnerList) {
        List<RetrievePartnerList.PartnerInfo> partnerInfoList = partnerList.stream()
                .map(partner -> RetrievePartnerList.PartnerInfo.builder()
                        .id(partner.getId())
                        .name(partner.getProfile().getName())
                        .build())
                .collect(Collectors.toList());

        return partnerInfoList;
    }
}
