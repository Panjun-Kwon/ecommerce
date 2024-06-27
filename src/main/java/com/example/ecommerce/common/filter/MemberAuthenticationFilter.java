package com.example.ecommerce.common.filter;

import com.example.ecommerce.common.exception.*;
import com.example.ecommerce.common.jwt.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.config.security.*;
import com.fasterxml.jackson.databind.*;
import io.jsonwebtoken.*;
import jakarta.annotation.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
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
@Slf4j
public class MemberAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;

    private List<RequestMatcher> requestMatcherList = new ArrayList<>();

    @PostConstruct
    public void init() {
        requestMatcherList.add(new AntPathRequestMatcher("/api/auth/member/**"));
        requestMatcherList.add(new AntPathRequestMatcher("/api/auth/members/**"));
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication = " + authentication);

        return (SecurityContextHolder.getContext().getAuthentication() != null ||
                requestMatcherList.stream().allMatch(requestMatcher -> !requestMatcher.matches(request)));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(jwtUtils.tokenHeader);
        String accessToken = jwtUtils.getAccessToken(token);
        try {
            if (StringUtils.hasText(accessToken)) {
                AuthMember authMember = jwtUtils.getAuthMember(accessToken);
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        authMember, null, authMember.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (JwtException e) {
            sendResponse(response, e);
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void sendResponse(HttpServletResponse response, JwtException e) throws IOException {
        log.warn("JwtException = {}", e.getClass());
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(objectMapper.writeValueAsString(
                CommonResponse.fail(e.getMessage(), ErrorCode.INVALID_AUTHENTICATION)));
    }
}
