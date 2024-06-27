package com.example.ecommerce.api;

import com.example.ecommerce.common.jwt.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.config.security.*;
import jakarta.servlet.http.*;
import lombok.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HealthController {

    private final JwtUtils jwtUtils;

    @GetMapping("/health")
    public CommonResponse<String> request(HttpServletRequest request) {

        String token = request.getHeader(jwtUtils.tokenHeader);

        String accessToken = jwtUtils.getAccessToken(token);
        if (StringUtils.hasText(accessToken)) {
            AuthMember authMember = jwtUtils.getAuthMember(accessToken);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authMember, null, authMember.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        return CommonResponse.success("request", "hi");
    }

    @GetMapping("/auth/health")
    public CommonResponse<String> authRequest() {
        return CommonResponse.success("auth request", "hi");
    }
}
