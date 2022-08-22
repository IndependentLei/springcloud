package com.example.cloudalibabaproviderpayment9001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @ClassName : PaymentController
 * @Author : jdl
 * @Create : 2022-08-21 13:09
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "nacos registry , serverPort:"+serverPort+"\t"+id;
    }
}
