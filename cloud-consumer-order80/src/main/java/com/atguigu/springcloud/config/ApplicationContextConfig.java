package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: XiaoDu
 * @CreateTime: 2023/5/4 21:28
 * @Description:
 */
@Configuration
public class ApplicationContextConfig {
    // 配置bean 不然后面没法依赖注入，就像以前ssm整合时配置依赖注入一样，
    // 需要在配置文件配置之后，代码中才可以依赖注入
    // 当前文件就是spring的配置文件
    @Bean
//    手写轮询 禁用
//    @LoadBalanced

//    @LoadBalanced //让这个RestTemplate在请求时拥有客户端负载均衡的能力  //将此注解注释掉，使用自己的轮询算法不使用默认的
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
