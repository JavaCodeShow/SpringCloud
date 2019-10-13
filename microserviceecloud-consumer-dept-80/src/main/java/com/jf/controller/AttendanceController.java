package com.jf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * @author 江峰
 * @create 2019-10-13   14:49
 * @description 测试调用nodejs项目的http rest接口
 */
@RestController
public class AttendanceController {
    private static final String PREFIX_URL = "http://localhost:7021";
    // / ioam / attendance / person

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/addendance")
    public Object getAttendance() {
        System.out.println("接受到了请求");
        ArrayList list = restTemplate.getForObject(PREFIX_URL + "/ioam/attendance/person", ArrayList.class);
        System.out.println("调用结束");
        System.out.println(list.get(0));
        System.out.println(list.get(0).getClass());
        return list;
    }
}
