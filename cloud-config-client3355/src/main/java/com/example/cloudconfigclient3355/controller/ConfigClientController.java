package com.example.cloudconfigclient3355.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @ClassName : ConfigClientController
 * @Author : jdl
 * @Create : 2022-08-18 23:06
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/getConfigInfo")
    private String getConfigInfo(){
        return configInfo;
    }
}
