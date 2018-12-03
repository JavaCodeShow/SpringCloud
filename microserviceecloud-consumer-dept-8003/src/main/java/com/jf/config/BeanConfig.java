package com.jf.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 潇潇暮雨
 * @create 2018-12-02   9:17
 */
@Configuration // 这个注解代替Spring的ApplicationContext.xml
public class BeanConfig {

    @Bean
    @LoadBalanced // Spring Cloud Ribbon是基于Netflix Ribbon试下你的一套客户端，负载均衡的工具。
    public RestTemplate getRestTemplate() {
        System.out.println("创造了一个bean,id为restTemplate");
        return new RestTemplate();
    }
}
































