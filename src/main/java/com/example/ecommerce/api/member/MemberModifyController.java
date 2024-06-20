package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.app.member.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.domain.member.entity.member.*;
import lombok.*;
import org.springframework.security.core.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Transactional
@RequiredArgsConstructor
public class MemberModifyController {

    private final MemberModifyService memberModifyService;

    @PutMapping("/auth/members/my/profile")
    public CommonResponse<Void> modifyProfile(
            @AuthenticationPrincipal AuthMember authMember,
            @Validated @RequestBody ProfileRequest request) {

        Long memberId = authMember.getMember().getId();
        memberModifyService.modifyProfile(memberId, request);
        String message = String.format("멤버(%d) 마이 프로필 수정", memberId);

        return CommonResponse.success(message, null);
    }
}
