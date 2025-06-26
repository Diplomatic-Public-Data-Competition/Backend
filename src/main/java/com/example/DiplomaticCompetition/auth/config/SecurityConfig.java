package com.example.DiplomaticCompetition.auth.config;

import com.example.DiplomaticCompetition.auth.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))

            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/**").hasRole("USER")
                .anyRequest().authenticated()
            )

            .logout(logout -> logout.logoutSuccessUrl("/"))

            .oauth2Login(oauth2 -> oauth2
                    .userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
                // 로그인 성공 시 REST API로 응답하고 싶다면 아래 핸들러 추가 (필요 시)
                //.successHandler(new CustomAuthenticationSuccessHandler())
            );

        return http.build();
    }

}