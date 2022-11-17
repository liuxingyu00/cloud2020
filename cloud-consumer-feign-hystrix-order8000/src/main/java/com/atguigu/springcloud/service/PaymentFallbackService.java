package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author wz
 * @Date 2022/11/15 11:02
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "hystrix 8000 模块调用 paymentInfo_OK 方法失败 o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "hystrix 8000 模块调用 paymentInfo_TimeOut 方法超时 或者 paymentInfo_TimeOut 方法运行时出错 o(╥﹏╥)o";
    }
}