package com.example.cloudalibabaconsumernacosorder84.proxy;

import com.example.pojo.CommentResult;
import com.example.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = FallBackOrderProxy.class)
public interface OrderProxy {
    @GetMapping("/provide/payment/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") String id);
}
