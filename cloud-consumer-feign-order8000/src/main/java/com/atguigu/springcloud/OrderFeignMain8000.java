package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author wz
 * @Date 2022/10/12 21:17
 */

@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain8000.class, args);
    }
}