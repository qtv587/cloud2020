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

/**
 * @Author: XiaoDu
 * @CreateTime: 2023/5/4 21:16
 * @Description:
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);

        return new CommonResult<Payment>(200, "select success， serverPort："+serverPort , payment);
    }

    @PostMapping("create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int insert = this.paymentService.insert(payment);
        log.info("插入结果："+insert);
        return new CommonResult<>(200, "insert success， serverPort："+serverPort,insert);
    }

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.stream().forEach(serviceInstance -> {
            System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());

        });
        return this.discoveryClient;
    }

}
