package com.example.ecommerce.api.partner;

import com.example.ecommerce.api.partner.request.Register;
import com.example.ecommerce.app.partner.PartnerRegisterService;
import com.example.ecommerce.common.response.CommonResponse;
import com.example.ecommerce.domain.partner.dto.PartnerCommand;
import com.example.ecommerce.domain.product.service.ProductMapper;
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
    private final ProductMapper productMapper;

    @PostMapping
    public CommonResponse<Long> registerPartner(@RequestBody Register request) {
        PartnerCommand.Register command = productMapper.commandOf(request);
        Long data = partnerRegisterService.register(command);
        String message = String.format("파트너 등록");

        return CommonResponse.success(message, data);
    }


}
