package com.example.ecommerce.domain.member.service;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.domain.member.dto.*;
import com.example.ecommerce.domain.member.entity.member.*;

import java.util.*;

public interface MemberMapper {
    MemberDetailResponse.MemberInfo retrieveDetailOf(Member member);

    List<MemberListResponse.MemberInfo> retrieveListOf(List<Member> memberPage);

    MemberPageResponse.MemberInfo retrieveMyPageDetailOf(Member member);

    MemberProfileResponse.ProfileInfo retrieveMyProfileDetailOf(Member member);

    SignUpCommand commandOf(SignUpRequest request);

    ProfileCommand commandOf(ProfileRequest request);
}
