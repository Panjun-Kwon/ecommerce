package com.example.ecommerce.api.partner;

import com.example.ecommerce.api.partner.request.*;
import com.example.ecommerce.api.partner.response.*;
import com.example.ecommerce.app.partner.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.domain.partner.command.*;
import jakarta.validation.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PartnerRegisterController {

    private final PartnerRegisterService partnerRegisterService;

    @PostMapping("/api/partners")
    public CommonResponse<PartnerIdResponse> registerPartner(@Valid @RequestBody RegisterRequest request) {
        Long partnerId = partnerRegisterService.register(RegisterCommand.of(request));
        return CommonResponse.success("파트너 등록", new PartnerIdResponse(partnerId));
    }
}
