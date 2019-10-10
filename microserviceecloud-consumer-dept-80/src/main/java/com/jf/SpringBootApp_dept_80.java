package com.jf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 潇潇暮雨
 * @create 2018-12-02   10:04
 */
@SpringBootApplication
// @EnableEurekaClient
// 在启动该微服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效。
// @RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration= MySelfRule.class)
public class SpringBootApp_dept_80 {
    public static void main(String[] args){
        SpringApplication.run(SpringBootApp_dept_80.class,args);
    }

}
