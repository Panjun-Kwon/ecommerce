package com.example.ecommerce.common.jwt;

import com.example.ecommerce.domain.member.entity.member.*;
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

import static com.example.ecommerce.common.jwt.JwtUtils.*;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final JwtUtils jwtUtils;
    private List<RequestMatcher> requestMatcherList = new ArrayList<>();

    @PostConstruct
    public void init() {
        requestMatcherList.add(new AntPathRequestMatcher("/api/auth/**"));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String accessToken = request.getHeader(TOKEN_HEADER);

        if (StringUtils.hasText(accessToken) && accessToken.startsWith(TOKEN_PREFIX)) {
            accessToken = accessToken.replace(TOKEN_PREFIX, "");

            AuthMember authMember = jwtUtils.getAuth(accessToken);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authMember, null, authMember.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return requestMatcherList.stream().allMatch(requestMatcher -> !requestMatcher.matches(request));
    }
}
