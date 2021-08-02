package com.jf.service;

import com.jf.entity.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 潇潇暮雨
 * @create 2018-12-05   10:25
 */
@FeignClient(name = "microservicecloud-dept-provider", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/add")
    boolean addDept(@RequestBody Department department);

    @GetMapping(value = "/dept/get/{id}")
    Department getDeptById(@PathVariable("id") Integer id);

    @GetMapping(value = "/dept/get/list")
    List<Department> getAllDept();
}
