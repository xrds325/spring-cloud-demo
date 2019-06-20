package com.nenglong.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author:zhaokai
 * @Description:
 * @Date:9:29 2019/6/17
 */
@RestController
public class HelloController {

    @GetMapping("/fallback")
    public Mono<String> fallback(){
        return Mono.just("fallback");
    }
}
