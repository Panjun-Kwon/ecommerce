package com.example.ecommerce.domain.member.dto;

import com.example.ecommerce.domain.member.entity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class MemberInfo {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberDetail {

        private Long id;
        private String username;
        private String city;
        private String street;

        public static MemberInfo.MemberDetail of(Member member) {
            return MemberInfo.MemberDetail.builder()
                    .id(member.getId())
                    .username(member.getUsername())
                    .city(member.getAddress().getCity())
                    .street(member.getAddress().getStreet())
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberList {

        private Long id;
        private String username;

        public static MemberInfo.MemberList of(Member member) {
            return MemberInfo.MemberList.builder()
                    .id(member.getId())
                    .username(member.getUsername())
                    .build();
        }
    }
}
