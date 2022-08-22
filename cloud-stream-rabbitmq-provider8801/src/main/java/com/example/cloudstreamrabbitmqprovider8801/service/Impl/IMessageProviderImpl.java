package com.example.cloudstreamrabbitmqprovider8801.service.Impl;

import com.example.cloudstreamrabbitmqprovider8801.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description :
 * @ClassName : IMessageProviderImpl
 * @Author : jdl
 * @Create : 2022-08-20 18:29
 */
@EnableBinding(Source.class) // 定义消息的推送通道
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("**********serial："+serial);
        return null;
    }
}
