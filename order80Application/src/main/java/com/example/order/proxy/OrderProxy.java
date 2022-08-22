package com.example.order.proxy;


import com.example.pojo.CommentResult;
import com.example.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cloud-payment-service")
public interface OrderProxy  {

    @PostMapping("/payment/create")
    CommentResult create(Payment payment);

    @GetMapping("/payment/getPaymentById/{id}")
    CommentResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
