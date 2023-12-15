package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @Author: XiaoDu
 * @CreateTime: 2023/5/4 21:21
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public Payment queryById(Long id) {
        ArrayList<Object> objects = new ArrayList<>();
        return paymentDao.queryById(id);
    }

    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }
}
