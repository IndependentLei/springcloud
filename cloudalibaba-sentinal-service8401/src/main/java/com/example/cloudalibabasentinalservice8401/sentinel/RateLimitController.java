package com.example.cloudalibabasentinalservice8401.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.cloudalibabasentinalservice8401.myHandle.CustomerBlockHandler;
import com.example.pojo.CommentResult;
import com.example.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @ClassName : RateLimitController
 * @Author : jdl
 * @Create : 2022-08-28 21:53
 */
@RestController
public class RateLimitController {

    // 按照资源限流
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommentResult<Payment> byResource(){
        return new CommentResult<>(200,"按照资源名限流测试ok",new Payment("2020","byResource"));
    }

    public CommentResult<Payment> handleException(BlockException ex){
        return new CommentResult<>(444,ex.getClass().getCanonicalName()+"\t服务不可用");
    }

    // 按照url限流
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommentResult<Payment> byUrl(){
        return new CommentResult<>(200,"按照url限流测试ok",new Payment("2020","byUrl"));
    }

    // 自定义兜底方法
    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler"
            ,blockHandlerClass = CustomerBlockHandler.class
            ,blockHandler = "handleException1",fallback = "fallbackException")
    public CommentResult<Payment> customerBlockHandler(){
        int i = 10 / 0; // java出现异常进入 fallback ， 限流进入 blockHandler
        return new CommentResult<>(200,"自定义兜底方法",new Payment("2020","customerBlockHandler"));
    }

    public CommentResult<Payment> fallbackException(){
        return new CommentResult<>(444,"fallbackException");
    }
}
