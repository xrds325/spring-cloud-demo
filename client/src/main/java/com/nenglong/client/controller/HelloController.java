package com.nenglong.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zhaokai
 * @Description:
 * @Date:9:56 2019/6/14
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String sayHi(){
        return "Hello Port:"+port;
    }
}
