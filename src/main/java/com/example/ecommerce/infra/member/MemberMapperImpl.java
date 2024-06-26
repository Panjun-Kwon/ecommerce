package com.example.ecommerce.infra.member;

import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.domain.member.entity.member.*;
import com.example.ecommerce.domain.member.service.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDetailResponse.MemberInfo memberDetailOf(Member member) {

        AddressResponse.AddressInfo addressInfo = addressOf(member);

        MemberProfileResponse.ProfileInfo profileInfo = memberProfileOf(member);

        MemberDetailResponse.MemberInfo memberInfo = MemberDetailResponse.MemberInfo.builder()
                .id(member.getId())
                .username(member.getUsername())
                .profile(new MemberProfileResponse(member.getId(), profileInfo))
                .address(addressInfo)
                .build();

        return memberInfo;
    }

    @Override
    public AddressResponse.AddressInfo addressOf(Member member) {

        AddressResponse.AddressInfo addressInfo = AddressResponse.AddressInfo.builder()
                .city(member.getProfile().getAddress() == null ? null : member.getProfile().getAddress().getStreet())
                .street(member.getProfile().getAddress() == null ? null : member.getProfile().getAddress().getStreet())
                .build();

        return addressInfo;
    }

    @Override
    public List<MemberListResponse.MemberInfo> memberListOf(List<Member> memberList) {

        List<MemberListResponse.MemberInfo> memberInfoList = memberList.stream()
                .map(member -> MemberListResponse.MemberInfo.builder()
                        .id(member.getId())
                        .username(member.getUsername())
                        .build())
                .collect(Collectors.toList());

        return memberInfoList;
    }

    @Override
    public MemberPageResponse.MemberInfo memberPageOf(Member member) {

        AddressResponse.AddressInfo addressInfo = addressOf(member);

        MemberProfileResponse.ProfileInfo profileInfo = memberProfileOf(member);

        MemberPageResponse.MemberInfo memberInfo = MemberPageResponse.MemberInfo.builder()
                .id(member.getId())
                .username(member.getUsername())
                .profile(profileInfo)
                .address(addressInfo)
                .build();

        return memberInfo;
    }

    @Override
    public MemberProfileResponse.ProfileInfo memberProfileOf(Member member) {
        MemberProfileResponse.ProfileInfo profileInfo = MemberProfileResponse.ProfileInfo.builder()
                .name(member.getProfile().getName())
                .email(member.getProfile().getEmail())
                .phoneNum(member.getProfile().getPhoneNum())
                .build();

        return profileInfo;
    }
}
