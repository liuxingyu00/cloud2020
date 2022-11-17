package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wz
 * @Date 2022/9/5 11:48
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // @LoadBalanced // 该注解提供了 RestTemplate 实现负载均衡的能力，并且默认使用的算法是轮询
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}