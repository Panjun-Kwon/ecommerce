package com.example.ecommerce.api.member.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RetrieveMemberList {

    private List<MemberInfo> memberList;
    private PageInfo page;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberInfo {
        private Long id;
        private String username;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PageInfo {
        private Integer currentElements;
        private Integer totalPages;
        private Long totalElements;
    }
}
