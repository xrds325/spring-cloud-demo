package com.nenglong.gateway.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author:zhaokai
 * @Description:
 * @Date:11:44 2019/6/17
 */
@Component
public class HostAddrKeyResolver implements KeyResolver {

//    /**
//     * 根据hostname进行限流
//     */
//    @Override
//    public Mono<String> resolve(ServerWebExchange exchange) {
//        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
//    }


    /**
     * 根据uri进行限流
     * @param exchange
     * @return
     */
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return  Mono.just(exchange.getRequest().getURI().getPath());
    }

}
