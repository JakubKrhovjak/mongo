package com.example.demo.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.reactive.BindingContext;
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolver;
import org.springframework.web.reactive.result.method.SyncHandlerMethodArgumentResolver;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * Created by Jakub krhovják on 5/28/21.
 */
public class CustomResolver implements SyncHandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return false;
    }

    @Override
    public Mono<Object> resolveArgument(
        MethodParameter methodParameter, BindingContext bindingContext, ServerWebExchange serverWebExchange
    ) {
        return null;
    }

    @Override
    public Object resolveArgumentValue(MethodParameter methodParameter, BindingContext bindingContext, ServerWebExchange serverWebExchange) {
        return null;
    }
}
