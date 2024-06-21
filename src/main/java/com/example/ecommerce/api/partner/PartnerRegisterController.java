package com.example.ecommerce.api.partner;

import com.example.ecommerce.api.partner.request.*;
import com.example.ecommerce.api.partner.response.*;
import com.example.ecommerce.app.partner.*;
import com.example.ecommerce.common.response.*;
import jakarta.validation.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partners")
@RequiredArgsConstructor
public class PartnerRegisterController {

    private final PartnerRegisterService partnerRegisterService;

    @PostMapping
    public CommonResponse<PartnerIdResponse> registerPartner(@Valid @RequestBody RegisterRequest request) {
        PartnerIdResponse data = partnerRegisterService.register(request);
        String message = String.format("파트너 등록");

        return CommonResponse.success(message, data);
    }


}
