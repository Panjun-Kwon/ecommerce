package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.dto.MemberResponse;
import com.example.ecommerce.app.member.MemberRetrieveService;
import com.example.ecommerce.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberRetrieveController {

    private final MemberRetrieveService memberRetrieveService;

    @GetMapping
    private CommonResponse<MemberResponse.MemberList> retrieveMemberList(Pageable pageable) {
        MemberResponse.MemberList data = memberRetrieveService.retrieveMemberList(pageable);
        String message = String.format("멤버 목록 조회");

        return CommonResponse.success(message, data);
    }

    @GetMapping("/{memberId}")
    public CommonResponse<MemberResponse.MemberDetail> retrieveMemberDetail(@PathVariable Long memberId) {
        MemberResponse.MemberDetail data = memberRetrieveService.retrieveMemberDetail(memberId);
        String message = String.format("멤버(%d) 상세 조회", memberId);

        return CommonResponse.success(message, data);
    }
}
