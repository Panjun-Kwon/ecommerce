package com.example.ecommerce.api.member.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class AccessTokenResponse {
    private Long memberId;
    private String accessToken;
}
