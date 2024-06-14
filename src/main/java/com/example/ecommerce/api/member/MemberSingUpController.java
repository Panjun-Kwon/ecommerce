package com.example.ecommerce.api.member;

import com.example.ecommerce.app.member.MemberSignUpService;
import com.example.ecommerce.common.response.CommonResponse;
import com.example.ecommerce.domain.member.dto.MemberCommand;
import lombok.RequiredArgsConstructor;
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
    public CommonResponse<Long> signUp(@RequestBody MemberCommand.SignUp command) {
        Long data = memberSignUpService.signUp(command);
        String message = String.format("회원 가입");

        return CommonResponse.success(message, data);
    }

}
