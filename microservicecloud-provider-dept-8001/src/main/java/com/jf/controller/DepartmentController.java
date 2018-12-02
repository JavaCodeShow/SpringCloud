package com.jf.controller;

import com.jf.entity.Department;
import com.jf.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 潇潇暮雨
 * @create 2018-12-01   20:47
 */

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // @RequestParam即支持GET请求，也支持POST请求。
    @GetMapping(value = "/dept/add1")
    public boolean addDept1(@RequestParam String deptName, @RequestParam String db_source) {
        Department department = new Department();
        department.setDeptName(deptName);
        department.setDb_source(db_source);
        return departmentService.addDept(department);
    }

    // @RequestBody只能支持POST请求
    @RequestMapping(value = "/dept/add")
    public boolean addDept(@RequestBody Department department) {
        System.out.println("执行了添加");
        System.out.println("执行了添加");
        System.out.println("执行了添加");
        return departmentService.addDept(department);
    }

    @GetMapping(value = "/dept/get/{id}")
    public Department getDeptById(@PathVariable("id") Integer id) {
        return departmentService.findDeptById(id);
    }

    @GetMapping(value = "/dept/get/list")
    public List<Department> getAllDept() {
        return departmentService.findAllDept();
    }


}
