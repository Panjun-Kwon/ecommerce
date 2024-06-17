package com.example.ecommerce.api.partner;

import com.example.ecommerce.api.partner.request.Register;
import com.example.ecommerce.app.partner.PartnerRegisterService;
import com.example.ecommerce.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partners")
@RequiredArgsConstructor
public class PartnerRegisterController {

    private final PartnerRegisterService partnerRegisterService;

    @PostMapping
    public CommonResponse<Long> registerPartner(@Validated @RequestBody Register request) {
        Long data = partnerRegisterService.register(request);
        String message = String.format("파트너 등록");

        return CommonResponse.success(message, data);
    }


}
