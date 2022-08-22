package com.example.order.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.example.order.ib.MyLb;
import com.example.order.proxy.OrderProxy;
import com.example.pojo.CommentResult;
import com.example.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    OrderProxy orderProxy;
    @Autowired
    DiscoveryClient discoveryClient;
    @Resource
    MyLb myLb;

    @PostMapping("/payment/create")
    public CommentResult<Payment> create(@RequestBody Payment payment){
        return orderProxy.create(payment);
//        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommentResult.class);
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return orderProxy.getPaymentById(id);
//        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommentResult.class);
    }

    @GetMapping("/myself/rule")
    public String mySelfRule(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances.isEmpty()){
            return null;
        }
        ServiceInstance instance = myLb.instance(instances);
        log.info("获取的实列为：{}",instance.getUri());
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/myself/rule",String.class);
    }
}
