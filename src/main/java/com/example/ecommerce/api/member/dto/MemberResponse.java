package com.example.ecommerce.api.member.dto;

import com.example.ecommerce.domain.member.dto.MemberInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class MemberResponse {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberDetail {
        private MemberInfo.MemberDetail member;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberList {
        private List<MemberInfo.MemberList> memberList;
        private Integer currentElements;
        private Integer totalPages;
        private Long totalElements;
    }
}
