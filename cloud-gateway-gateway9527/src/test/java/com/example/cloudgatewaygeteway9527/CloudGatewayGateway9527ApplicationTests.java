package com.example.cloudgatewaygeteway9527;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

@SpringBootTest
class CloudGatewayGateway9527ApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        //2022-08-17T22:47:03.734+08:00[Asia/Shanghai]
    }
}
