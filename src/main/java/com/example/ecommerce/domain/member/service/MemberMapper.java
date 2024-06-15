package com.example.ecommerce.domain.member.service;

import com.example.ecommerce.api.member.request.SignUp;
import com.example.ecommerce.api.member.response.RetrieveMemberDetail;
import com.example.ecommerce.api.member.response.RetrieveMemberList;
import com.example.ecommerce.domain.member.dto.MemberCommand;
import com.example.ecommerce.domain.member.entity.member.Member;

import java.util.List;

public interface MemberMapper {
    RetrieveMemberDetail.MemberInfo retrieveDetailOf(Member member);

    List<RetrieveMemberList.MemberInfo> retrieveListOf(List<Member> memberPage);

    MemberCommand.SignUp commandOf(SignUp request);
}
