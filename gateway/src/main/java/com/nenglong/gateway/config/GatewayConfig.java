package com.nenglong.gateway.config;

import com.nenglong.gateway.filter.HostAddrKeyResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @Author:zhaokai
 * @Description:
 * @Date:9:04 2019/6/17
 */
@Configuration
public class GatewayConfig {
    @Autowired
    HostAddrKeyResolver hostAddrKeyResolver;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){

        return builder.routes()
//                .route(p -> p
//                        .path("/get")
//                        .filters(f->f
//                                .addRequestHeader("hello","wrold"))
//                        .uri("http://httpbin.org:80"))
//                .route(p -> p
//                        .path("/abc")
//                        .filters(f -> f
//                                .hystrix(config -> config
//                                        .setName("mycmd")
//                                        .setFallbackUri("forward:/fallback")))
//                        .uri("http://localhost:8080"))
//                .route(p->p
//                        .after(ZonedDateTime.of(2019,7,17,11,0,0,0,ZoneId.systemDefault()))
//                        .uri("http://httpbin.org:80"))
//                .route(p->p.header("X-Request-Id","\\d+").uri("http://httpbin.org:80"))
//                .route(p->p.cookie("mycookie","sb").uri("http://httpbin.org:80"))
//                .route(p->p.method("GET").uri("http://httpbin.org:80"))
//                .route(p->p.path("/foo/{segment}").uri("http://httpbin.org:80/get"))
//                .route(p->p.query("foo","sb").uri("http://httpbin.org:80"))
//                .route(p->p
//                        .path("/**")
//                        .filters(f->f.addRequestHeader("X-Request-Foo","sb"))
//                        .uri("http://httpbin.org:80"))
//                .route(p->p.path("/foo/**")
//                        .filters(f->f.rewritePath("/foo/(?<segment>.*)","/$\\{segment}"))
//                        .uri("https://blog.csdn.net"))
                .route(p->p.path("/**")
                        .filters(f->f
                                .requestRateLimiter(config -> config
                                        .setKeyResolver(hostAddrKeyResolver)
                                        .setRateLimiter(new RedisRateLimiter(1,3))))
                        .uri("http://httpbin.org:80"))
                .build();
    }
}
