package com.example.seataorderservice2001.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pojo.Order;
import com.example.seataorderservice2001.dao.OrderDao;
import com.example.seataorderservice2001.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

}
