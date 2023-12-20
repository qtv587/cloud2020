package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() +"\t"+ "paymentInfoOK(),id:"+ id+ "\t" +" \"O(∩_∩) 成功返回哈哈哈";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        Integer timeOutNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeOutNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() +"\t"+ "paymentInfoTimeout(),id:"+ id+ "\t" +" \"O(∩_∩) 成功返回哈哈哈";
    }
}
