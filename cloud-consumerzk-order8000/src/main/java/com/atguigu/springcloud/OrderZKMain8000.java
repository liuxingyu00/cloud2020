package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author wz
 * @Date 2022/10/4 10:41
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain8000.class, args);
    }
}