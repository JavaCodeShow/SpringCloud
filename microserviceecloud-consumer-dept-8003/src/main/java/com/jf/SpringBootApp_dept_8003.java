package com.jf;


import com.rule.MySelfRule;
import com.rule.RandomRule_ZY;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 潇潇暮雨
 * @create 2018-12-02   10:04
 */
@SpringBootApplication
@EnableEurekaClient
// 在启动该微服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效。
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration= MySelfRule.class)
public class SpringBootApp_dept_8003 {
    public static void main(String[] args){
        SpringApplication.run(SpringBootApp_dept_8003.class,args);
    }

}
