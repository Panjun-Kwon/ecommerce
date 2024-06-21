package com.example.ecommerce.domain.member.service;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.domain.member.command.*;
import com.example.ecommerce.domain.member.entity.member.*;

import java.util.*;

public interface MemberMapper {
    MemberDetailResponse.MemberInfo memberDetailOf(Member member);

    AddressResponse.AddressInfo addressOf(Member member);

    List<MemberListResponse.MemberInfo> memberListOf(List<Member> memberPage);

    MemberPageResponse.MemberInfo memberPageOf(Member member);

    MemberProfileResponse.ProfileInfo memberProfileOf(Member member);

    SignUpCommand commandOf(SignUpRequest request);
}
