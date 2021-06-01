package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.ReactivePageableHandlerMethodArgumentResolver;
import org.springframework.web.reactive.config.WebFluxConfigurationSupport;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;

/**
 * Created by Jakub krhovják on 5/16/21.
 */

@Configuration
public class WebConfig extends WebFluxConfigurationSupport {

    @Override
    protected void configureArgumentResolvers(ArgumentResolverConfigurer configurer) {
        configurer.addCustomResolver(new CustomResolver());


        configurer.addCustomResolver(new ReactivePageableHandlerMethodArgumentResolver());

    }
    CustomResolver customResolver() {
        return new CustomResolver();
    }

    @Bean
    RFilter rFilter() {
        return new RFilter();
    }
}
