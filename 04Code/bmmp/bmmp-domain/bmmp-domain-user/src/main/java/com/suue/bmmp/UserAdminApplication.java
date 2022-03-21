package com.suue.bmmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 品牌管理服务启动类
 * Created by shuds on 2022/3/17
 **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class UserAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserAdminApplication.class);
    }
}
