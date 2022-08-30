package com.example.seataorderservice2001.controller;

import com.example.pojo.CommentResult;
import com.example.pojo.Order;
import com.example.seataorderservice2001.service.OrderService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public CommentResult<Boolean> createOrder(@RequestBody Order order){
        return new CommentResult<>(200,"ok",orderService.create(order));
    }

    @PostMapping("/update")
    public CommentResult<Boolean> updateOrder(@RequestBody Order order){
        return new CommentResult<>(200,"ok",orderService.updateByUserId(order));
    }
}
