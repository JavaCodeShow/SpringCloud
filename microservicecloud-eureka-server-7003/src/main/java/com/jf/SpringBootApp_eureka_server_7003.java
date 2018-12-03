package com.jf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 潇潇暮雨
 * @create 2018-12-02   23:25
 */
@SpringBootApplication
@EnableEurekaServer  //EurekaServer服务器端启动类,接受其它微服务注册进来
public class SpringBootApp_eureka_server_7003 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp_eureka_server_7003.class, args);
    }
}
