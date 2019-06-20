package com.nenglong.feign.client;

import com.nenglong.feign.client.hystric.HelloClientHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author:zhaokai
 * @Description:
 * @Date:10:56 2019/6/14
 */
@FeignClient(value = "EUREKA-CLIENT",fallback = HelloClientHystric.class)
public interface HelloClient {

    @GetMapping("/hello")
    String sayHi();
}
