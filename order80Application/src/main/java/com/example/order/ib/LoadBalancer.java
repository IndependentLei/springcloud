package com.example.order.ib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description :
 * @ClassName : LoadBalancer
 * @Author : jdl
 * @Create : 2022-08-10 22:47
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
