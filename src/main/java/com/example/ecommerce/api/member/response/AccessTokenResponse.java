package com.example.ecommerce.api.member.response;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenResponse {
    private Long memberId;
    private String accessToken;
}
