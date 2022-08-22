package com.example.cloudalibabaconfignacosclient3377.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @ClassName : ConfigClientController
 * @Author : jdl
 * @Create : 2022-08-21 14:15
 */
@RestController
@RefreshScope //支持Naocs的动态刷新功能
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
