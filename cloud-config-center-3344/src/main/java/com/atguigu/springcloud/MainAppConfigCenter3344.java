package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableConfigServer
public class MainAppConfigCenter3344
{
    public static void main( String[] args )
    {
        SpringApplication.run(MainAppConfigCenter3344.class,args);
    }
}
