package com.jf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author 潇潇暮雨
 * @create 2018-12-02   10:04
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringBootApp_dept_8003 {
    public static void main(String[] args){
        SpringApplication.run(SpringBootApp_dept_8003.class,args);
    }
}
