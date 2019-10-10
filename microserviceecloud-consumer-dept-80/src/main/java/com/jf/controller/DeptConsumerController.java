package com.jf.controller;


import com.jf.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 潇潇暮雨
 * @create 2018-12-02   10:17
 */
@RestController
public class DeptConsumerController {
    private static final String URI_Prefix = "http://localhost:8001";
    // Ribbon和Eureka整合后可以直接调用服务名而不用再关心ip地址和端口号。
    // private static final String URI_Prefix = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    // @RequestBody只能支持POST请求
    @PostMapping(value = "/consumer/dept/add")
    public boolean addDept(@RequestBody Department department) {
        System.out.println("执行了这个方法");
        return restTemplate.postForObject(URI_Prefix + "/dept/add", department, Boolean.class);
    }

    @GetMapping(value = "/consumer/dept/get/{id}")
    public Department getDeptList(@PathVariable Integer id) {
        Department department = restTemplate.getForObject(URI_Prefix + "/dept/get/" + id, Department.class);
        return department;
    }

    @GetMapping(value = "/consumer/dept/get/list")
    public List<Department> getDeptList() {
        List<Department> deptList = restTemplate.getForObject(URI_Prefix + "/dept/get/list", List.class);
        return deptList;
    }

    @GetMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(URI_Prefix + "/dept/discovery", Object.class);
    }


}
