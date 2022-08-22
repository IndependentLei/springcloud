package com.example.payment.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.payment.dao.PaymentDao;
import com.example.payment.service.PaymentService;
import com.example.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentDao , Payment> implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        Payment hasPayment = getPaymentById(payment.getId());
        if (hasPayment == null){
            return paymentDao.insert(payment);
        }
        return 0;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
