package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author wz
 * @Date 2022/8/28 16:28
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("插入结果：" + i);
        if (i != 1) {
            return new CommonResult(444, "插入数据失败", null);
        }
        return new CommonResult(200, "插入数据成功, serverPort = " + serverPort, i);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：" + payment);
        if (payment == null) {
            return new CommonResult(444, "查询数据失败", null);
        }
        return new CommonResult(200, "查询数据成功, serverPort = " + serverPort, payment);
    }

    /**
     * 服务消费者 => 获取访问服务提供者的端口号
     *
     * @return
     */
    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
