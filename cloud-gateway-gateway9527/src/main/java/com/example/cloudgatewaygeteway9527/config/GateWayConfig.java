package com.example.cloudgatewaygeteway9527.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description :
 * @ClassName : GateWayConfig
 * @Author : jdl
 * @Create : 2022-08-17 20:51
 */
@Configuration
public class GateWayConfig {
    /**
     * 配置一个id为route-name的路由规则
     * 当访问地址为http://localhost:9527/guonei 时候会自动转发到地址 http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_guonei",predicateSpec -> predicateSpec.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
