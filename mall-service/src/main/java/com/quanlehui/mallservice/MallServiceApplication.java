package com.quanlehui.mallservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

@Slf4j
@EnableAsync
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.quanlehui.mallservice.mapper")
@ComponentScan(basePackages = {"com.quanlehui.mallservice","com.quanlehui.servicebase.base"})
@SpringBootApplication
public class MallServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServiceApplication.class, args);
    }

}
