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
    @LoadBalanced // Spring Cloud Ribbon是基于Netflix Ribbon的一套客户端，负载均衡的工具。
    public RestTemplate getRestTemplate() {
        System.out.println("创造了一个bean,id为restTemplate");
        return new RestTemplate();
    }
    // 将Ribbon的负载均衡策略的随机算法的bean注入进来，用来代替默认的轮询算法。
//    @Bean
//    public IRule myRule() {
//        return new RandomRule();
//    }

}
































