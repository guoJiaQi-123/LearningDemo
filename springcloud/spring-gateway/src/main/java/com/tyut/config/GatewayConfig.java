package com.tyut.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version v1.0
 * @author OldGj 2024/8/26
 * @apiNote JavaAPI配置网关
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder builder = routeLocatorBuilder.routes();
        RouteLocatorBuilder.Builder route = builder.route("payment",
                r -> r.path("/api/payment/**")
                        .uri("http://localhost:8001"));
        return route.build();
    }
}
