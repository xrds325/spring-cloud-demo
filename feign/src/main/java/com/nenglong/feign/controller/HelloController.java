package com.nenglong.feign.controller;

import com.nenglong.feign.client.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zhaokai
 * @Description:
 * @Date:10:57 2019/6/14
 */
@RestController
public class HelloController {

    @Autowired
    HelloClient helloClient;

    @GetMapping("/hello")
    public String sayHi(){
        return helloClient.sayHi();
    }
}
