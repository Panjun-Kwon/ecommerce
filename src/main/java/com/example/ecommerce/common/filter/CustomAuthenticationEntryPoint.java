package com.example.ecommerce.common.filter;

import com.example.ecommerce.common.exception.*;
import com.example.ecommerce.common.response.*;
import com.fasterxml.jackson.databind.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.security.core.*;
import org.springframework.security.web.*;
import org.springframework.stereotype.*;

import java.io.*;

@Component
@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        log.warn("AuthenticationException = {}", authException.getClass());
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(
                objectMapper.writeValueAsString(CommonResponse.fail(authException.getMessage(), ErrorCode.INVALID_AUTHENTICATION)));
    }
}
