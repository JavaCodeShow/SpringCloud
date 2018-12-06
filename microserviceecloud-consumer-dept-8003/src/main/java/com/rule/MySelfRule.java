package com.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 潇潇暮雨
 * @create 2018-12-04   14:28
 */

@Configuration
public class MySelfRule {

    // 将Ribbon的负载均衡策略的随机算法的bean注入进来，用来代替默认的轮询算法。
    @Bean
    public IRule myRule() {
        return new RandomRule_ZY();
    }
}
  