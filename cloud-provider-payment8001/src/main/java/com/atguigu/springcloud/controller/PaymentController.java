package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author wz
 * @Date 2022/8/28 16:28
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

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
     * 获取服务提供者的实例
     *
     * @return
     */
    @GetMapping("/payment/discovery")
    public Object discovery() {
        // 获取注册中心中所有的服务名称
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service: " + service);
        }
        // 获取 CLOUD-PAYMENT-SERVICE 服务所有的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + ", " + instance.getHost() + ", " + instance.getPort() + ", " + instance.getUri());
        }
        return discoveryClient;
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

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
