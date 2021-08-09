package com.example.demo.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


/**
 * Created by Jakub krhovják on 7/27/21.
 */
@RestController
@RequestMapping
public class LoginController {

    @PostMapping("/token")
    public Mono<String> login(@RequestBody Credential credential) {
        return Mono.just("test123");
    }
}
