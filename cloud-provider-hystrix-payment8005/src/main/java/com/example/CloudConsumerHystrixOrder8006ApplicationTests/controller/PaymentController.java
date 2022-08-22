package com.example.CloudConsumerHystrixOrder8006ApplicationTests.controller;

import com.example.CloudConsumerHystrixOrder8006ApplicationTests.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @ClassName : PaymentController
 * @Author : jdl
 * @Create : 2022-08-11 23:25
 */
@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/healthy/{id}")
    public String healthy(@PathVariable("id") Integer id){
        return paymentService.healthy(id);
    }

    @GetMapping("/payment/failure/{id}")
    public String failure(@PathVariable("id") Integer id){
        return paymentService.failure(id);
    }

    @GetMapping("/payment/circuitBreaker/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
