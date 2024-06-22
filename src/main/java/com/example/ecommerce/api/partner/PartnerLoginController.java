package com.example.ecommerce.api.partner;

import com.example.ecommerce.api.partner.request.*;
import com.example.ecommerce.api.partner.response.*;
import com.example.ecommerce.app.partner.*;
import com.example.ecommerce.common.response.*;
import jakarta.validation.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PartnerLoginController {

    private final PartnerLoginService partnerLoginService;

    @PostMapping("/api/partners/login")
    public CommonResponse<AccessTokenResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        AccessTokenResponse data = partnerLoginService.login(loginRequest);
        String message = "로그인";
        return CommonResponse.success(message, data);
    }

}
