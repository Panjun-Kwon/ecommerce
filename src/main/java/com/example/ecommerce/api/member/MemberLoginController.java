package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.app.member.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.domain.member.info.*;
import jakarta.validation.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberLoginController {

    private final MemberLoginService memberLoginService;

    @PostMapping("/api/members/login")
    public CommonResponse<AccessTokenResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        AccessTokenInfo info = memberLoginService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return CommonResponse.success("로그인", info.toResponse());
    }

}
