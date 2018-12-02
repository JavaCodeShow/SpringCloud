package com.jf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 潇潇暮雨
 * @create 2018-12-02   9:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    @Autowired
    private ApplicationContext ac;

    @Test
    public void fun() {
        System.out.println(ac.containsBean("getRestTemplate"));
        System.out.println(ac.containsBean("getRestTemplate"));
        System.out.println(ac.containsBean("getRestTemplate"));
        System.out.println(ac.containsBean("getRestTemplate"));
    }

}
