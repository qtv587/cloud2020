package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: XiaoDu
 * @CreateTime: 2023/5/4 21:20
 * @Description:
 */
@Mapper
public interface PaymentDao {
    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 影响行数
     */
    int insert(Payment payment);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Payment queryById(Long id);
}
