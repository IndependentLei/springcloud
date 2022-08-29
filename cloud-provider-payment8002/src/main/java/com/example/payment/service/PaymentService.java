package com.example.payment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.Payment;

public interface PaymentService extends IService<Payment> {
    int create(Payment payment);
    Payment getPaymentById(String id);
}
