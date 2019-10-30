package com.jf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 潇潇暮雨
 * @create 2018-12-01   21:09
 */
@SpringBootApplication
@EnableConfigServer // 开启分布式配置服务中心
public class SpringBootApp_config_server_3344 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp_config_server_3344.class, args);
    }
}
