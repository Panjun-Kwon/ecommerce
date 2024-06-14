package com.example.ecommerce.api.partner;

import com.example.ecommerce.app.partner.PartnerRegisterService;
import com.example.ecommerce.common.response.CommonResponse;
import com.example.ecommerce.domain.partner.dto.PartnerCommand;
import lombok.RequiredArgsConstructor;
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
    public CommonResponse<Long> registerPartner(@RequestBody PartnerCommand.Register command) {
        Long data = partnerRegisterService.register(command);
        String message = String.format("파트너 등록");

        return CommonResponse.success(message, data);
    }


}
