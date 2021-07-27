package com.example.demo.config;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;


/**
 * Created by Jakub krhovják on 7/22/21.
 */

@EnableWebFluxSecurity
public class SecurityConfiguration  {

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("user")
            .roles("USER")
            .build();
        return new MapReactiveUserDetailsService(user);
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
            .authorizeExchange(exchanges ->
                exchanges
                    .pathMatchers("/", "/login")
                    .authenticated()
                    .anyExchange().authenticated()
            )
            .cors()

            .and()
            .csrf()
            .disable()

//            .csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse())
//            .and()

            .httpBasic(withDefaults())
            .formLogin(withDefaults());
        return http.build();
    }
}
