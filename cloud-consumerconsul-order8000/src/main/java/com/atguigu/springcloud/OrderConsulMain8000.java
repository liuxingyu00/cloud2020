package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author wz
 * @Date 2022/10/5 14:19
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain8000.class, args);
    }
}