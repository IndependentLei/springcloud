package com.example.cloudalibabaconsumernacosorder83.proxy;

import com.example.pojo.CommentResult;
import com.example.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description :
 * @ClassName : OrderProxy
 * @Author : jdl
 * @Create : 2022-08-24 0:23
 */
@FeignClient("nacos-payment-provider")
@Component
public interface OrderProxy {
    @GetMapping("/payment/nacos/{id}")
    String paymentInfo(@PathVariable("id") Integer id);

    @PostMapping("/payment/nacos/create")
    String create(@RequestBody Payment payment);
}
