package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.response.RetrieveMemberDetail;
import com.example.ecommerce.api.member.response.RetrieveMemberList;
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

    @GetMapping("/{memberId}")
    public CommonResponse<RetrieveMemberDetail> retrieveMemberDetail(@PathVariable Long memberId) {
        RetrieveMemberDetail data = memberRetrieveService.retrieveMemberDetail(memberId);
        String message = String.format("멤버(%d) 상세 조회", memberId);

        return CommonResponse.success(message, data);
    }

    @GetMapping
    private CommonResponse<RetrieveMemberList> retrieveMemberList(Pageable pageable) {
        RetrieveMemberList data = memberRetrieveService.retrieveMemberList(pageable);
        String message = String.format("멤버 목록 조회");

        return CommonResponse.success(message, data);
    }
}
