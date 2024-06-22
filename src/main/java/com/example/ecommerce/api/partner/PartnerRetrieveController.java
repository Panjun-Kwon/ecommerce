package com.example.ecommerce.api.partner;

import com.example.ecommerce.api.partner.response.*;
import com.example.ecommerce.app.partner.*;
import com.example.ecommerce.common.response.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PartnerRetrieveController {

    private final PartnerRetrieveService partnerRetrieveService;

    @GetMapping("/api/partners")
    public CommonResponse<RetrievePartnerList> retrievePartnerList(Pageable pageable) {
        RetrievePartnerList data = partnerRetrieveService.retrievePartnerList(pageable);
        String message = String.format("파트너 목록 조회");

        return CommonResponse.success(message, data);
    }

    @GetMapping("/api/partners/{partnerId}")
    public CommonResponse<RetrievePartnerDetail> retrievePartnerDetail(@PathVariable Long partnerId) {
        RetrievePartnerDetail data = partnerRetrieveService.retrievePartnerDetail(partnerId);
        String message = String.format("파트너(%d) 상세 조회", partnerId);

        return CommonResponse.success(message, data);
    }
}
