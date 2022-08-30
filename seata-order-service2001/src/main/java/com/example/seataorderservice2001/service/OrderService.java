package com.example.seataorderservice2001.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.Order;

public interface OrderService extends IService<Order> {
    Boolean updateByUserId(Order order);

    Boolean create(Order order);
}
