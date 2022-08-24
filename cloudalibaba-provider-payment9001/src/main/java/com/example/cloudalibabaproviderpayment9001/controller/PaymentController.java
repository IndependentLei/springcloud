package com.example.cloudalibabaproviderpayment9001.controller;

import com.example.pojo.CommentResult;
import com.example.pojo.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/payment/nacos/create")
    public String create(@RequestBody Payment payment){
        return  "插入成功,serverPort:"+serverPort;
    }
}
