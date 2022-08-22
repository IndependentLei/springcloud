package com.example.payment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PaymentDao extends BaseMapper<Payment>{
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
