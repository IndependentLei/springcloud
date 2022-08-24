package com.example.cloudalibabaconsumernacosorder83.controller;

import com.example.cloudalibabaconsumernacosorder83.proxy.OrderProxy;
import com.example.pojo.CommentResult;
import com.example.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description :
 * @ClassName : OrderController
 * @Author : jdl
 * @Create : 2022-08-21 13:33
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String serverUrl;

    @Autowired
    OrderProxy orderProxy;

    @GetMapping("/consumer/payment/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
//        return restTemplate.getForObject(serverUrl+"/payment/nacos/"+id,String.class);
        return orderProxy.paymentInfo(id);
    }

    @PostMapping("/consumer/payment/create")
    public String create(@RequestBody Payment payment){
//        return restTemplate.getForObject(serverUrl+"/payment/nacos/"+id,String.class);
        return orderProxy.create(payment);
    }
}
