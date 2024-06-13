package com.example.ecommerce.infra.partner;

import com.example.ecommerce.api.partner.response.RetrievePartnerDetail;
import com.example.ecommerce.api.partner.response.RetrievePartnerList;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.partner.service.PartnerMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PartnerMapperImpl implements PartnerMapper {
    @Override
    public RetrievePartnerDetail.PartnerInfo retrieveDetailOf(Partner partner) {
        RetrievePartnerDetail.PartnerInfo partnerInfo = RetrievePartnerDetail.PartnerInfo.builder()
                .id(partner.getId())
                .name(partner.getName())
                .build();

        return partnerInfo;
    }

    @Override
    public List<RetrievePartnerList.PartnerInfo> retrieveListOf(List<Partner> partnerList) {
        List<RetrievePartnerList.PartnerInfo> partnerInfoList = partnerList.stream()
                .map(partner -> RetrievePartnerList.PartnerInfo.builder()
                        .id(partner.getId())
                        .name(partner.getName())
                        .build())
                .collect(Collectors.toList());

        return partnerInfoList;
    }
}
