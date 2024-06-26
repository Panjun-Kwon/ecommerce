package com.example.ecommerce.domain.member.info;

import com.example.ecommerce.api.member.response.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenInfo {
    private Long memberId;
    private String accessToken;

    public AccessTokenResponse toResponse() {
        if (this == null) return new AccessTokenResponse();

        return new AccessTokenResponse(this.memberId, this.accessToken);
    }
}
