package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: XiaoDu
 * @CreateTime: 2023/5/4 21:16
 * @Description:
 */
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;


    @GetMapping("get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = this.paymentService.queryById(id);

        return new CommonResult<Payment>(200, "select success， serverPort：" +serverPort , payment);
    }

    @PostMapping("create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int insert = this.paymentService.insert(payment);
        System.out.println(insert);
        System.out.println("1234567890");
        return new CommonResult<>(200, "insert success， serverPort："+serverPort,insert);
    }


}
