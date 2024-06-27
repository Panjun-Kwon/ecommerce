package com.example.ecommerce.config.security;

import com.example.ecommerce.common.filter.*;
import lombok.*;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.config.http.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.util.matcher.*;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final AuthMemberService authMemberService;
    private final AuthPartnerService authPartnerService;
    private final MemberAuthenticationFilter memberAuthenticationFilter;
    private final PartnerAuthenticationFilter partnerAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable);

        http
                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(authenticationEntryPoint))
                .authenticationProvider(memberAuthenticationProvider())
                .authenticationProvider(partnerAuthenticationProvider())
                .addFilterBefore(memberAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(partnerAuthenticationFilter, MemberAuthenticationFilter.class);

        http
                .authorizeHttpRequests(
                        authorizeRequest ->
                                authorizeRequest
                                        .requestMatchers(
                                                AntPathRequestMatcher.antMatcher("/api/auth/**")
                                        ).authenticated()
                                        .anyRequest().permitAll()
                );


        return http.build();
    }

    @Bean
    public AuthenticationProvider memberAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(authMemberService);
        provider.setPasswordEncoder(passwordEncoder());
        provider.setHideUserNotFoundExceptions(false);
        return provider;
    }

    @Bean
    public AuthenticationProvider partnerAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(authPartnerService);
        provider.setPasswordEncoder(passwordEncoder());
        provider.setHideUserNotFoundExceptions(false);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
