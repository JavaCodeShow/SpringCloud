package com.jf;

import com.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 潇潇暮雨
 * @create 2018-12-02   10:04
 */
@SpringBootApplication
@EnableEurekaClient
// 在启动该微服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效。也可以不加，不加的话就是使用ribbon默认的轮询算法
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySelfRule.class)
@EnableDiscoveryClient // 开启服务发现，也可以不开，注释掉没关系
public class SpringBootApp_dept_80 {
    public static void main(String[] args){
        SpringApplication.run(SpringBootApp_dept_80.class,args);
    }
}
