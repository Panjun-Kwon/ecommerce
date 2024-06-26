package com.example.ecommerce.domain.partner.info;

import com.example.ecommerce.api.partner.response.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class AccessTokenInfo {
    private Long partnerId;
    private String accessToken;

    public AccessTokenResponse toResponse() {
        if (this == null) return new AccessTokenResponse();
        return new AccessTokenResponse(this.partnerId, this.accessToken);
    }
}
