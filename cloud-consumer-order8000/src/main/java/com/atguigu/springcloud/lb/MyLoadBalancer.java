package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author wz
 * @Date 2022/10/10 16:45
 */

public interface MyLoadBalancer {

    /**
     * 通过服务实例集合（8001、8002）获取要访问的实例（8001 或者 8002）
     *
     * @param serviceInstanceList
     * @return
     */
    ServiceInstance getVisitedInstance(List<ServiceInstance> serviceInstanceList);

}
