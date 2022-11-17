package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wz
 * @Date 2022/10/8 22:00
 */

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 使用随机策略的负载均衡算法
        return new RandomRule();
    }

}