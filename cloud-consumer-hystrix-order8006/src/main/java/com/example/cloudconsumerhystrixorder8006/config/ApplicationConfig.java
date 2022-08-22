package com.example.cloudconsumerhystrixorder8006.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description :
 * @ClassName : ApplicationConfig
 * @Author : jdl
 * @Create : 2022-08-13 15:21
 */
@Configuration
public class ApplicationConfig {

        /**
         * 注入RestTemplate
         * @return
         */
        @Bean
//    @LoadBalanced
        public RestTemplate getRestTemplate(){
            return new RestTemplate();
        }
}
