package com.example.cloudconsumerhystrixorder8006.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description :
 * @ClassName : OrderHystrixProxy
 * @Author : jdl
 * @Create : 2022-08-13 15:06
 */
@FeignClient(name = "CLOUD-PROVIDER-HYSTRIX-PAYMENT8005",fallback = OrderFallbackProxy.class) // fallback兜里类
@Component
public interface OrderHystrixProxy {
    @GetMapping("/payment/healthy/{id}")
    public String healthy(@PathVariable("id") Integer id);

    @GetMapping("/payment/failure/{id}")
    public String failure(@PathVariable("id") Integer id);
}
