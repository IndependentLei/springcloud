package com.example.cloudalibabaconsumernacosorder84.proxy;

import com.example.pojo.CommentResult;
import com.example.pojo.Payment;
import org.springframework.stereotype.Component;

@Component
public class FallBackOrderProxy implements OrderProxy {
    @Override
    public CommentResult<Payment> getPayment(String id) {
        return new CommentResult<>(4444,"服务降级",new Payment("0","error serial"));
    }
}
