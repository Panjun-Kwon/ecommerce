package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.api.partner.response.RetrievePartnerDetail;
import com.example.ecommerce.api.partner.response.RetrievePartnerList;
import com.example.ecommerce.domain.partner.entity.partner.Partner;

import java.util.List;

public interface PartnerMapper {
    RetrievePartnerDetail.PartnerInfo retrieveDetailOf(Partner partner);

    List<RetrievePartnerList.PartnerInfo> retrieveListOf(List<Partner> content);
}
