package com.example.cloudstreamrabbitmqconsumer8804;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudStreamRabbitmqConsumer8804Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitmqConsumer8804Application.class, args);
    }

}
