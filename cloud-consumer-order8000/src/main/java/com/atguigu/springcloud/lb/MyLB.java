package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wz
 * @Date 2022/10/10 16:52
 */

@Component
public class MyLB implements MyLoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current > 2147483647 ? 0 : current + 1;
        } while(!this.atomicInteger.compareAndSet(current, next));
        System.out.println("请求接口的次数: " + next);

        return next;
    }

    /**
     * 模仿 RoundRobinRule 轮询算法来获取消费者机器
     *
     * @param serviceInstanceList
     * @return
     */
    @Override
    public ServiceInstance getVisitedInstance(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}