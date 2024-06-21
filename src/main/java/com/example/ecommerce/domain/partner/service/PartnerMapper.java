package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.api.partner.response.*;
import com.example.ecommerce.domain.partner.entity.partner.*;

import java.util.*;

public interface PartnerMapper {
    RetrievePartnerDetail.PartnerInfo retrieveDetailOf(Partner partner);

    List<RetrievePartnerList.PartnerInfo> retrieveListOf(List<Partner> content);
}
