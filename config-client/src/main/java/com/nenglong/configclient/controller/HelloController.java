package com.nenglong.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zhaokai
 * @Description:
 * @Date:16:04 2019/6/14
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${foo}")
    private String foo;

    @GetMapping("/hello")
    public String sayHello(){
        return foo;
    }
}
