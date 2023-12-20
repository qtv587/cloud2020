package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "-----消费端服务降级---paymentInfoOk";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "-----消费端服务降级---paymentInfoTimeOut";
    }
}
