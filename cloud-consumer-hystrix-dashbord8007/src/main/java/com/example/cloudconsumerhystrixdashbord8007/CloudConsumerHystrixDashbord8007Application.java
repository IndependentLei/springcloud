package com.example.cloudconsumerhystrixdashbord8007;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class CloudConsumerHystrixDashbord8007Application {
// http://localhost:8007/hystrix.stream 地址
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrixDashbord8007Application.class, args);
    }

}
