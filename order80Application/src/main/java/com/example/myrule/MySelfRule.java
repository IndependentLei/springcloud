package com.example.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description :
 * @ClassName : MySelfRule
 * @Author : jdl
 * @Create : 2022-08-08 23:35
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myselfRule(){
        return new RandomRule();
    }
}
