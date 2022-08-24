package com.example.cloudalibabasentinalservice8401.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @ClassName : SentinelController
 * @Author : jdl
 * @Create : 2022-08-24 23:01
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @GetMapping("/testA")
    public String sentinelA(){
        return "testA";
    }

    @GetMapping("/testB")
    public String sentinelB(){
        return "testB";
    }
}
