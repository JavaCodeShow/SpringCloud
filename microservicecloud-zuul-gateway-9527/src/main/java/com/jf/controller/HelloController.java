package com.jf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潇潇暮雨
 * @create 2018-12-05   21:56
 */


@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

}
