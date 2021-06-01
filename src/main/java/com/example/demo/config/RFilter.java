package com.example.demo.config;

import com.example.demo.entity.table.TableRequest;
import java.lang.reflect.Executable;
import java.lang.reflect.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Created by Jakub krhovják on 5/28/21.
 */
@Slf4j
public class RFilter implements WebFilter {

    @Autowired
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
//        HandlerMethod handler = (HandlerMethod) requestMappingHandlerMapping.getHandler(serverWebExchange).toProcessor().peek();
//        MethodParameter[] methodParameters = handler.getMethodParameters();
//        var a = methodParameters[0];
//        var tableRequest =  a.getExecutable();
//        Parameter[] parameters = tableRequest.getParameters();
//       var b = parameters[0];
//        ServerHttpRequest request = serverWebExchange.getRequest();
//        Flux<DataBuffer> body = request.getBody();
//       body.map(v -> {
//            log.info("", v);
//            return v;
//        }).count()
//            .subscribe();
        return webFilterChain.filter(serverWebExchange);
    }
    //
//    @Override
//    public Mono<ServerResponse> filter(
//        ServerRequest serverRequest, HandlerFunction<ServerResponse> handlerFunction
//    ) {
//        return null;
//    }
}
