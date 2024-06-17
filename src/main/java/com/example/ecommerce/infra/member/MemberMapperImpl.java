package com.example.ecommerce.infra.member;

import com.example.ecommerce.api.member.request.SignUp;
import com.example.ecommerce.api.member.response.RetrieveMemberDetail;
import com.example.ecommerce.api.member.response.RetrieveMemberList;
import com.example.ecommerce.domain.member.dto.MemberCommand;
import com.example.ecommerce.domain.member.entity.member.Address;
import com.example.ecommerce.domain.member.entity.member.Member;
import com.example.ecommerce.domain.member.service.MemberMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public RetrieveMemberDetail.MemberInfo retrieveDetailOf(Member member) {
        
        RetrieveMemberDetail.AddressInfo addressInfo = RetrieveMemberDetail.AddressInfo.builder()
                .city(member.getAddress() == null ? null : member.getAddress().getStreet())
                .street(member.getAddress() == null ? null : member.getAddress().getStreet())
                .build();

        RetrieveMemberDetail.MemberInfo memberInfo = RetrieveMemberDetail.MemberInfo.builder()
                .id(member.getId())
                .username(member.getUsername())
                .address(addressInfo)
                .build();

        return memberInfo;
    }

    @Override
    public List<RetrieveMemberList.MemberInfo> retrieveListOf(List<Member> memberList) {

        List<RetrieveMemberList.MemberInfo> memberInfoList = memberList.stream()
                .map(member -> RetrieveMemberList.MemberInfo.builder()
                        .id(member.getId())
                        .username(member.getUsername())
                        .build())
                .collect(Collectors.toList());

        return memberInfoList;
    }

    @Override
    public MemberCommand.SignUp commandOf(SignUp request) {

        Address address = Address.builder()
                .city(request.getAddress() == null ? null : request.getAddress().getCity())
                .street(request.getAddress() == null ? null : request.getAddress().getStreet())
                .build();

        MemberCommand.SignUp command = MemberCommand.SignUp.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .name(request.getName())
                .phoneNum(request.getPhoneNum())
                .email(request.getEmail())
                .address(address)
                .build();

        return command;
    }
}
