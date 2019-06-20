package com.nenglong.feign.client.hystric;

import com.nenglong.feign.client.HelloClient;
import org.springframework.stereotype.Component;

/**
 * @Author:zhaokai
 * @Description:
 * @Date:13:50 2019/6/14
 */
@Component
public class HelloClientHystric implements HelloClient {

    @Override
    public String sayHi() {
        return "sorry error";
    }
}
