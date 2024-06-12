package com.example.ecommerce.api.member.dto;

import com.example.ecommerce.domain.member.dto.MemberInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class MemberResponse {

    @Data
    @Builder
    @AllArgsConstructor
    public static class MemberDetail {
        private MemberInfo.MemberDetail member;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class MemberList {
        private List<MemberInfo.MemberList> memberList;
        private Integer currentElements;
        private Integer totalPages;
        private Long totalElements;
    }
}
