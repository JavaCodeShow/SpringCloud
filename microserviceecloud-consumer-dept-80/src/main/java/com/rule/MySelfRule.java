package com.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 江峰
 * @create 2019-10-18   11:07
 */

@Configuration
public class MySelfRule {

    /**
     * 将Ribbon的负载均衡策略的随机算法的bean注入进来，用来代替默认的轮询算法。
     *
     * @return 负载均衡策略
     */
    @Bean
    public IRule myRule() {
        //     return new RandomRule();
        //     return new RetryRule();
        return new RandomRule_ZY();
    }
}
