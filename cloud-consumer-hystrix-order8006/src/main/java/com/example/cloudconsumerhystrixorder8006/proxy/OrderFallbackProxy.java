package com.example.cloudconsumerhystrixorder8006.proxy;

/**
 * @Description : 兜底方法类
 * @ClassName : OrderFallbackProxy
 * @Author : jdl
 * @Create : 2022-08-13 22:44
 */
public class OrderFallbackProxy implements OrderHystrixProxy{
    @Override
    public String healthy(Integer id) {
        return "--- OrderFallbackProxy healthy fall back ---";
    }

    @Override
    public String failure(Integer id) {
        return "--- OrderFallbackProxy failure fall back ---";
    }
}
