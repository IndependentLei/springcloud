package com.example.cloudgatewaygeteway9527.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Description :
 * @ClassName : MyLogGateWayFilter
 * @Author : jdl
 * @Create : 2022-08-17 23:05
 */
@Component
public class MyLogGateWayFilter implements Ordered, GlobalFilter {

    //http://localhost:9527/payment/getPaymentById/1?uname=9  请求地址必须带着 uname

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("come in MyLogGateWayFilter :"+new Date().toString());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            System.out.println("*****用户名为null,非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
