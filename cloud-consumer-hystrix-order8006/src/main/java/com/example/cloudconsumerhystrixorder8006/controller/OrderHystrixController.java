package com.example.cloudconsumerhystrixorder8006.controller;

import com.example.cloudconsumerhystrixorder8006.proxy.OrderHystrixProxy;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description :
 * @ClassName : OrderHystixController
 * @Author : jdl
 * @Create : 2022-08-13 15:04
 */
@RestController
@DefaultProperties(defaultFallback = "orderGlobalFallback") // 全局兜底方法
public class OrderHystrixController {

    @Resource
    RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/order/healthy/{id}")
    public String healthy(@PathVariable("id") Integer id){
        return restTemplate.getForObject("http://localhost:8005/payment/healthy/"+id,String.class);
    }

    @GetMapping("/order/failure/{id}")
    @HystrixCommand(fallbackMethod = "fallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String failure(@PathVariable("id") Integer id){
        int age = 10 / 0;
        return restTemplate.getForObject("http://localhost:8005/payment/failure/"+id,String.class);
    }

    public String fallbackMethod(@PathVariable("id") Integer id){
        return "指定兜底方法  --> 我是消费者8006，对方支付系统繁忙请10秒钟后再试一下或者自己运行出错请检查自己，~~~///(^v^)~~~";
    }

    @HystrixCommand  // 没有指定专属的兜底方法
    @GetMapping("order/isnotspecified")
    public String IsNotSpecified(){
        int age = 10 / 0;
        return "";
    }

    public String orderGlobalFallback(){
        return "全局兜底方法   ---->  我是消费者8006，对方支付系统繁忙请10秒钟后再试一下或者自己运行出错请检查自己，~~~///(^v^)~~~";
    }
}
