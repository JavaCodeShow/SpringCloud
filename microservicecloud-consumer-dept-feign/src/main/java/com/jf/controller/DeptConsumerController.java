package com.jf.controller;


import com.jf.entity.Department;
import com.jf.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 潇潇暮雨
 * @create 2018-12-02   10:17
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;

    // @RequestBody只能支持POST请求
    @RequestMapping(value = "/dept/add")
    public boolean addDept(@RequestBody Department department) {
        return deptClientService.addDept(department);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Department getDeptList(@PathVariable Integer id) {
        return deptClientService.getDeptById(id);
    }

    @GetMapping(value = "/consumer/dept/get/list")
    public List<Department> getDeptList() {
        return deptClientService.getAllDept();
    }

}
