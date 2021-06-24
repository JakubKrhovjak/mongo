package com.example.demo.config;

import com.example.demo.Event.domain.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.ReactivePageableHandlerMethodArgumentResolver;
import org.springframework.web.reactive.config.WebFluxConfigurationSupport;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;


/**
 * Created by Jakub krhovják on 5/16/21.
 */

@Configuration
public class WebConfig extends WebFluxConfigurationSupport {

    private static final String JOKE_API_ENDPOINT = "https://official-joke-api.appspot.com/jokes/random";

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

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
            .baseUrl(JOKE_API_ENDPOINT)
            .build();
    }


    @Bean
    public Sinks.Many<Event> sink(){
        return Sinks.many().replay().latest();
    }

    @Bean
    public Flux<Event> flux(Sinks.Many<Event> sink){
        return sink.asFlux();
    }
}
