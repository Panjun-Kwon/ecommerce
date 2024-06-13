package com.example.ecommerce.api.partner;

import com.example.ecommerce.api.partner.response.RetrievePartnerDetail;
import com.example.ecommerce.api.partner.response.RetrievePartnerList;
import com.example.ecommerce.app.partner.PartnerRetrieveService;
import com.example.ecommerce.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partners")
@RequiredArgsConstructor
public class PartnerRetrieveController {

    private final PartnerRetrieveService partnerRetrieveService;

    @GetMapping
    public CommonResponse<RetrievePartnerList> retrievePartnerList(Pageable pageable) {
        RetrievePartnerList data = partnerRetrieveService.retrievePartnerList(pageable);
        String message = String.format("파트너 목록 조회");

        return CommonResponse.success(message, data);
    }

    @GetMapping("/{partnerId}")
    public CommonResponse<RetrievePartnerDetail> retrievePartnerDetail(@PathVariable Long partnerId) {
        RetrievePartnerDetail data = partnerRetrieveService.retrievePartnerDetail(partnerId);
        String message = String.format("파트너(%d) 상세 조회", partnerId);

        return CommonResponse.success(message, data);
    }
}
