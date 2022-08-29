package com.example.cloudalibabaproviderpayment9003.controller;

import com.example.pojo.CommentResult;
import com.example.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class PaymentController {

    private static final Map<String,String>  finalMap = new HashMap();

    static {
        for (int i = 1; i < 5 ; i++) {
            finalMap.put(i+"", UUID.randomUUID().toString());
        }
    }

    @GetMapping("/provide/payment/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") String id){
        if(finalMap.containsKey(id)){
            String serial = finalMap.get(id);
            return new CommentResult<>(200,"ok",new Payment(id,serial));
        }
        finalMap.get(id).toCharArray();
        return new CommentResult<>(200,"no found",new Payment(id,"no found"));
    }
}
