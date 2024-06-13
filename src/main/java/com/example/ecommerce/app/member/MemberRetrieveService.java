package com.example.ecommerce.app.member;

import com.example.ecommerce.api.member.response.RetrieveMemberDetail;
import com.example.ecommerce.api.member.response.RetrieveMemberList;
import com.example.ecommerce.domain.member.entity.member.Member;
import com.example.ecommerce.domain.member.service.MemberMapper;
import com.example.ecommerce.domain.member.service.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberRetrieveService {

    private final MemberReader memberReader;
    private final MemberMapper memberMapper;

    public RetrieveMemberDetail retrieveMemberDetail(Long memberId) {
        Member member = memberReader.getMember(memberId);
        RetrieveMemberDetail.MemberInfo memberInfo = memberMapper.retrieveDetailOf(member);

        return new RetrieveMemberDetail(memberInfo);
    }

    public RetrieveMemberList retrieveMemberList(Pageable pageable) {
        Page<Member> memberPage = memberReader.getMemberAll(pageable);
        List<RetrieveMemberList.MemberInfo> memberInfoList = memberMapper.retrieveListOf(memberPage.getContent());

        RetrieveMemberList.PageInfo pageInfo = makePageInfo(memberPage);

        return new RetrieveMemberList(memberInfoList, pageInfo);
    }

    private static RetrieveMemberList.PageInfo makePageInfo(Page<Member> memberPage) {
        return RetrieveMemberList.PageInfo.builder()
                .currentElements(memberPage.getNumberOfElements())
                .totalPages(memberPage.getTotalPages())
                .totalElements(memberPage.getTotalElements())
                .build();
    }
}
