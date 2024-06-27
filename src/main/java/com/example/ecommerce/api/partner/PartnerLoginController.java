package com.example.ecommerce.api.partner;

import com.example.ecommerce.api.partner.request.*;
import com.example.ecommerce.api.partner.response.*;
import com.example.ecommerce.app.partner.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.domain.partner.info.*;
import jakarta.validation.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PartnerLoginController {

    private final PartnerLoginService partnerLoginService;

    @PostMapping("/api/partners/login")
    public CommonResponse<AccessTokenResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        AccessTokenInfo info = partnerLoginService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return CommonResponse.success("로그인", info.toResponse());
    }

}
