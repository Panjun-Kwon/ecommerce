package com.example.ecommerce.infra.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.domain.member.dto.*;
import com.example.ecommerce.domain.member.entity.member.*;
import com.example.ecommerce.domain.member.service.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDetailResponse.MemberInfo retrieveDetailOf(Member member) {

        MemberDetailResponse.AddressInfo addressInfo = MemberDetailResponse.AddressInfo.builder()
                .city(member.getAddress() == null ? null : member.getAddress().getStreet())
                .street(member.getAddress() == null ? null : member.getAddress().getStreet())
                .build();

        MemberDetailResponse.MemberInfo memberInfo = MemberDetailResponse.MemberInfo.builder()
                .id(member.getId())
                .username(member.getUsername())
                .name(member.getName())
                .email(member.getEmail())
                .phoneNum(member.getPhoneNum())
                .address(addressInfo)
                .build();

        return memberInfo;
    }

    @Override
    public List<MemberListResponse.MemberInfo> retrieveListOf(List<Member> memberList) {

        List<MemberListResponse.MemberInfo> memberInfoList = memberList.stream()
                .map(member -> MemberListResponse.MemberInfo.builder()
                        .id(member.getId())
                        .username(member.getUsername())
                        .build())
                .collect(Collectors.toList());

        return memberInfoList;
    }

    @Override
    public MemberMyPageResponse.MemberInfo retrieveMyPageDetailOf(Member member) {

        MemberMyPageResponse.AddressInfo addressInfo = MemberMyPageResponse.AddressInfo.builder()
                .city(member.getAddress() == null ? null : member.getAddress().getStreet())
                .street(member.getAddress() == null ? null : member.getAddress().getStreet())
                .build();

        MemberMyPageResponse.MemberInfo memberInfo = MemberMyPageResponse.MemberInfo.builder()
                .id(member.getId())
                .username(member.getUsername())
                .name(member.getName())
                .email(member.getEmail())
                .phoneNum(member.getPhoneNum())
                .address(addressInfo)
                .build();

        return memberInfo;
    }

    @Override
    public SignUpCommand commandOf(SignUpRequest request) {

        AddressCommand addressCommand = AddressCommand.builder()
                .city(request.getAddress() == null ? null : request.getAddress().getCity())
                .street(request.getAddress() == null ? null : request.getAddress().getStreet())
                .build();

        SignUpCommand command = SignUpCommand.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .name(request.getName())
                .phoneNum(request.getPhoneNum())
                .email(request.getEmail())
                .address(addressCommand)
                .build();

        return command;
    }
}
