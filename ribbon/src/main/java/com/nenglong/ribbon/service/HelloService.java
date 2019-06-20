package com.nenglong.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:zhaokai
 * @Description:
 * @Date:11:36 2019/6/14
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "saySorry")
    public String sayHello(){
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello",String.class);
    }

    public String saySorry(){
        return "Sorry Error";
    }
}
