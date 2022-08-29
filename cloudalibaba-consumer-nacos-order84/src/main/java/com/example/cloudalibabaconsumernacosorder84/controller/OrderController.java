package com.example.cloudalibabaconsumernacosorder84.controller;

import com.example.cloudalibabaconsumernacosorder84.proxy.OrderProxy;
import com.example.pojo.CommentResult;
import com.example.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    OrderProxy orderProxy;

    @GetMapping("/consumer/order/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") String id){
        return orderProxy.getPayment(id);
    }
}
