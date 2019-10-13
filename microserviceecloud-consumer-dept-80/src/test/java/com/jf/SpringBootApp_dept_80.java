package com.jf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author 潇潇暮雨
 * @create 2018-12-02   9:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootApp_dept_80 {
    private final String PREFIX_URL = "http://localhost:7021";

    @Autowired
    private ApplicationContext ac;

    @Test
    public void fun() {
        System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));
        System.out.println(ac.containsBean("restTemplate"));
        System.out.println(ac.containsBean("restTemplate"));
        System.out.println(ac.containsBean("restTemplate"));
        System.out.println(ac.containsBean("restTemplate"));
        System.out.println(ac.containsBean("restTemplate"));
        System.out.println(ac.containsBean("restTemplate"));
        System.out.println(ac.containsBean("restTemplate"));
        System.out.println(ac.containsBean("restTemplate"));
    }

    @Test
    public void attendance() {
        RestTemplate restTemplate = (RestTemplate) ac.getBean("restTemplate");
        Object forObject = restTemplate.getForObject(PREFIX_URL + "/ioam/attendance/person", Object.class);
        System.out.println(forObject.getClass());
    }

}
