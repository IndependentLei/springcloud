package com.example.cloudstreamrabbitmqprovider8801.controller;

import com.example.cloudstreamrabbitmqprovider8801.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description :
 * @ClassName : SendMessageController
 * @Author : jdl
 * @Create : 2022-08-20 20:01
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
