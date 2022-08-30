package com.example.seataorderservice2001.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pojo.Account;
import com.example.pojo.Order;
import com.example.pojo.Storage;
import com.example.seataorderservice2001.dao.OrderDao;
import com.example.seataorderservice2001.service.AccountService;
import com.example.seataorderservice2001.service.OrderService;
import com.example.seataorderservice2001.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

    @Autowired
    AccountService accountService;

    @Autowired
    StorageService storageService;

    @Autowired
    OrderDao orderDao;

    @Override
    public Boolean updateByUserId(Order order) {
        return this.update(order,new LambdaQueryWrapper<Order>().eq(Order::getUserId,order.getUserId()));
    }

    @Override
    public Boolean create(Order order) {
        log.info("------> 开始新建订单");
//        orderDao.insert(order);
//        save(order);
        log.info("------> 开始扣库存");
        storageService.updateStorage(order.getProductId(),order.getCount());
        log.info("------> 开始扣钱");
        accountService.updateAccount(order.getUserId(),order.getMoney());

        log.info("------> 开始 更改状态");
        return updateByUserId(order);
    }
}
