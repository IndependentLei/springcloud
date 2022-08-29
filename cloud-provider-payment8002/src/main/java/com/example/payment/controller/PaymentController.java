package com.example.payment.controller;

import com.example.payment.service.PaymentService;
import com.example.pojo.CommentResult;
import com.example.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @RequestMapping
    public String index(){
        return "index";
    }

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    PaymentService paymentService;

    /**
     * 新增支付订单
     * @param payment
     * @return
     */
    @PostMapping("/create")
    public CommentResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果*****"+result);
        return  result > 0 ? new CommentResult(200,"插入成功,serverPort:"+serverPort,result) : new CommentResult(400,"插入失败,serverPort:"+serverPort,null);
    }

    /**
     * 更具id获取订单
     * @param id
     * @return
     */
    @GetMapping("/getPaymentById/{id}")
    public CommentResult getPaymentById(@PathVariable("id") String id ){
        Payment payment = paymentService.getPaymentById(id);
        return  payment == null ? new CommentResult<>(400,"没有该订单,serverPort:"+serverPort,null) : new CommentResult(200,"查询成功,serverPort:"+serverPort,payment);
    }

    @GetMapping("/myself/rule")
    public String mySelfRule(){
        return serverPort;
    }
}
