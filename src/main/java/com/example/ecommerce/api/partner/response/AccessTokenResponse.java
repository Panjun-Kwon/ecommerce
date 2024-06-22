package com.example.ecommerce.api.partner.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class AccessTokenResponse {
    private Long partnerId;
    private String accessToken;
}
