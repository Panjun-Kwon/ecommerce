package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.request.SignUp;
import com.example.ecommerce.app.member.MemberSignUpService;
import com.example.ecommerce.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberSingUpController {

    private final MemberSignUpService memberSignUpService;

    @PostMapping
    public CommonResponse<Long> signUp(@Validated @RequestBody SignUp request) {
        Long data = memberSignUpService.signUp(request);
        String message = String.format("회원 가입");

        return CommonResponse.success(message, data);
    }

}
