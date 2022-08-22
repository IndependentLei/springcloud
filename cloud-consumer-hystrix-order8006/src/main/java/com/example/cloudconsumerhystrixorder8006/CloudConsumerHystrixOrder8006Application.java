package com.example.cloudconsumerhystrixorder8006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.example.cloudconsumerhystrixorder8006.proxy"})
@EnableCircuitBreaker  // 回路
public class CloudConsumerHystrixOrder8006Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrixOrder8006Application.class, args);
    }

}
