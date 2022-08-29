package com.example.cloudalibabasentinalservice8401.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @ClassName : SentinelController
 * @Author : jdl
 * @Create : 2022-08-24 23:01
 */
@RestController
public class SentinelController {

    @GetMapping("/testA")
    public String sentinelA(){
        return "testA";
    }

    @GetMapping("/testB")
    public String sentinelB(){
        return "testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "hotKeyBlockHandler")
    public String testHotKey(@RequestParam(value = "name",required = false)String name,@RequestParam(value = "age",required = false) String age){
        return String.format("name:%s,age:%s",name,age)+"------"+"testHotKey";
    }

    public String hotKeyBlockHandler(String name, String age, BlockException blockException){
        return String.format("name:%s,age:%s",name,age)+"------"+"hotKeyBlockHandler";
    }
}
