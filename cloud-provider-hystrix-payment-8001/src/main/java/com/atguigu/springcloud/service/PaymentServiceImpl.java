package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() +"\t"+ "paymentInfoOK(),id:"+ id+ "\t" +" \"O(∩_∩) 成功返回哈哈哈";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")})
    public String paymentInfoTimeOut(Integer id) {
        Integer timeOutNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeOutNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() +"\t"+ "paymentInfoTimeout(),id:"+ id+ "\t" +" \"O(∩_∩) 成功返回哈哈哈";
    }
    public String paymentInfoTimeOutHandler(Integer id){
        return "线程池： " + Thread.currentThread().getName() +"\t"+ "paymentInfoTimeOutHandler(),id:"+ id+ "\t" +" \"/(ㄒoㄒ)/~~ ";
    }
}
