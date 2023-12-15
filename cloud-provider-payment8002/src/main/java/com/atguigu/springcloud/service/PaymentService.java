package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @Author: XiaoDu
 * @CreateTime: 2023/5/4 21:17
 * @Description:
 */

public interface PaymentService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Payment queryById(Long id);
    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    int insert(Payment payment);
}
