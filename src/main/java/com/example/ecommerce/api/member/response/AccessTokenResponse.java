package com.example.ecommerce.api.member.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class AccessTokenResponse {
    private Long id;
    private String accessToken;
}
