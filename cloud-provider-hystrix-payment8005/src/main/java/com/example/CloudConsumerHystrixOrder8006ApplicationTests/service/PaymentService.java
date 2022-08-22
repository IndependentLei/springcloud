package com.example.CloudConsumerHystrixOrder8006ApplicationTests.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import sun.nio.ch.IOUtil;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description :
 * @ClassName : PaymentService
 * @Author : jdl
 * @Create : 2022-08-11 23:20
 */
@Service
public class PaymentService {

    @Value("${server.port}")
    private String serverPort;

    public String healthy(Integer id){
        return "healthy  --->"+ Thread.currentThread().getName()+"--->" +serverPort + "------->"+id;
    }

    /**
     * fallbackMethod 兜底方法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000") // 超过三秒进入兜底方法
    })
    public String failure(Integer id){
        try {
            TimeUnit.SECONDS.sleep(5);  //超时
//            int age = 10 / 0 ;  // 报错异常
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "failure ---> "+Thread.currentThread().getName()+ "---->"+ serverPort+ "--->" +id;
    }

    public String fallbackMethod(Integer id){
        return "fallbackMethod --->"+Thread.currentThread().getName()+ "---->" +serverPort+"--->"+id;
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value="true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("********* id 不能为负数");
        }
        String serialNumber = UUID.randomUUID().toString();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Integer id){
        return "id 不能为负数，请稍后再试,id ===" +id;
    }
}
