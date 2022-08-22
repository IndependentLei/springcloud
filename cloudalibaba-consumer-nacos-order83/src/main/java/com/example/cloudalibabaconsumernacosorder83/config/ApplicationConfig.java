package com.example.cloudalibabaconsumernacosorder83.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description :
 * @ClassName : ApplicationConfig
 * @Author : jdl
 * @Create : 2022-08-21 13:32
 */
@Configuration
public class ApplicationConfig {

    @Bean
    @LoadBalanced //只要使用ribbon就要使用这个注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
