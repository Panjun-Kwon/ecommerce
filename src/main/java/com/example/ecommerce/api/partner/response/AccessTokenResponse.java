package com.example.ecommerce.api.partner.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenResponse {
    private Long partnerId;
    private String accessToken;
}
