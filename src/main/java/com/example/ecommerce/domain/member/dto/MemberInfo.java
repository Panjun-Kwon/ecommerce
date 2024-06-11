package com.example.ecommerce.domain.member.dto;

import com.example.ecommerce.domain.member.entity.member.Member;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberInfo {

    private Long id;
    private String username;
    private String city;
    private String street;

    public static MemberInfo detailOf(Member member) {
        return MemberInfo.builder()
                .id(member.getId())
                .username(member.getUsername())
                .city(member.getAddress().getCity())
                .street(member.getAddress().getStreet())
                .build();
    }

    public static MemberInfo of(Member member) {
        return MemberInfo.builder()
                .id(member.getId())
                .username(member.getUsername())
                .build();
    }
}
