package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.app.member.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.domain.member.command.*;
import lombok.*;
import org.springframework.transaction.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequiredArgsConstructor
public class MemberSingUpController {

    private final MemberSignUpService memberSignUpService;

    @PostMapping("/api/members")
    public CommonResponse<MemberIdResponse> signUp(@Validated @RequestBody SignUpRequest request) {
        Long memberId = memberSignUpService.signUp(SignUpCommand.of(request));
        return CommonResponse.success("회원 가입", new MemberIdResponse(memberId));
    }

}
