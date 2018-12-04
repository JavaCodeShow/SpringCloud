package com.jf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author 潇潇暮雨
 * @create 2018-12-01   21:09
 */
@SpringBootApplication
@EnableEurekaClient // 本服务启动后会自动注册进eureka服务中。
@EnableDiscoveryClient // 开启服务发现
@EnableHystrix // 开启对熔断机制的支持
public class SpringBootApp_dept_hystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp_dept_hystrix_8001.class, args);
    }
}
