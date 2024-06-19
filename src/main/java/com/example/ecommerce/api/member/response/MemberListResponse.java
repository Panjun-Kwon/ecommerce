package com.example.ecommerce.api.member.response;

import lombok.*;

import java.util.*;

@Getter
@AllArgsConstructor
public class MemberListResponse {

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
