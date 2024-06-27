package com.example.ecommerce.common.filter;

import com.example.ecommerce.common.jwt.*;
import com.example.ecommerce.config.security.*;
import jakarta.annotation.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.web.util.matcher.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;
import org.springframework.web.filter.*;

import java.io.*;
import java.util.*;

@Component
@RequiredArgsConstructor
public class PartnerAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;

    private List<RequestMatcher> requestMatcherList = new ArrayList<>();

    @PostConstruct
    public void init() {
        requestMatcherList.add(new AntPathRequestMatcher("/api/auth/partner/**"));
        requestMatcherList.add(new AntPathRequestMatcher("/api/auth/partners/**"));
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return (SecurityContextHolder.getContext().getAuthentication() != null ||
                requestMatcherList.stream().allMatch(requestMatcher -> !requestMatcher.matches(request)));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(jwtUtils.tokenHeader);

        String accessToken = jwtUtils.getAccessToken(token);
        if (StringUtils.hasText(accessToken)) {
            AuthPartner authPartner = jwtUtils.getAuthPartner(accessToken);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authPartner, null, authPartner.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
