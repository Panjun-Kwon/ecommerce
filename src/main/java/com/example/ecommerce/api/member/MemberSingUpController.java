package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.app.member.*;
import com.example.ecommerce.common.response.*;
import lombok.*;
import org.springframework.transaction.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@Transactional
@RequiredArgsConstructor
public class MemberSingUpController {

    private final MemberSignUpService memberSignUpService;

    @PostMapping
    public CommonResponse<MemberIdResponse> signUp(@Validated @RequestBody SignUpRequest request) {
        MemberIdResponse data = memberSignUpService.signUp(request);
        String message = "회원 가입";
        return CommonResponse.success(message, data);
    }

}
