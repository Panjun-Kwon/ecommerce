package com.example.ecommerce.app.member;

import com.example.ecommerce.api.member.dto.MemberResponse;
import com.example.ecommerce.domain.member.dto.MemberInfo;
import com.example.ecommerce.domain.member.entity.member.Member;
import com.example.ecommerce.domain.member.service.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberRetrieveService {

    private final MemberReader memberReader;

    public MemberResponse.MemberList retrieveMemberList(Pageable pageable) {
        Page<Member> memberList = memberReader.getMemberAll(pageable);

        List<MemberInfo.MemberList> responseList = memberList.stream()
                .map(member -> MemberInfo.MemberList.of(member))
                .collect(Collectors.toList());

        return MemberResponse.MemberList.builder()
                .memberList(responseList)
                .currentElements(memberList.getNumberOfElements())
                .totalPages(memberList.getTotalPages())
                .totalElements(memberList.getTotalElements())
                .build();
    }

    public MemberResponse.MemberDetail retrieveMemberDetail(Long memberId) {
        Member member = memberReader.getMember(memberId);

        MemberInfo.MemberDetail response = MemberInfo.MemberDetail.of(member);

        return MemberResponse.MemberDetail.builder()
                .member(response)
                .build();
    }
}
