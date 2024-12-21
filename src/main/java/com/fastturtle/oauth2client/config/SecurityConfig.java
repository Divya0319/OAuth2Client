package com.fastturtle.oauth2client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/public/**").permitAll()
                                .requestMatchers("/favicon.ico", "/default-ui.css", "/js/**", "/css/**", "/images/**").permitAll()
                        .anyRequest().authenticated()
                        )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/oauth2/authorization/custom-client")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true") // Redirect to /login with error parameter on failure
                );

        return http.build();
    }
}
