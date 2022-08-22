package com.example.order.ib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description :
 * @ClassName : MyLb
 * @Author : jdl
 * @Create : 2022-08-10 22:48
 */
@Component
@Slf4j
public class MyLb implements LoadBalancer{
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndCompare(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current+1;
        }while (!atomicInteger.compareAndSet(current,next)); // 失败进行自旋
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        // 获取取余下标的实例
        int index = getAndCompare() % serviceInstances.size();
        log.info("当前轮询坐标：{},总实例数量：{}",index,serviceInstances.size());
        return serviceInstances.get(index);
    }

}
