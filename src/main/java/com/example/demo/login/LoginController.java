package com.example.demo.login;

import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


/**
 * Created by Jakub krhovják on 7/27/21.
 */
@RestController
public class LoginController {

    public Mono<String> login() {
        return Mono.just("test123");
    }
}
