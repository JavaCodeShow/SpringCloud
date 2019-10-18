package com.jf.controller;

import com.jf.entity.Department;
import com.jf.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    /**
     * 服务发现，通过这个可以获取当前服务的配置信息。
     */
    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping(value="/dept/discovery")
    public DiscoveryClient discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println("-----------------------" + services + "-------------------------");
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost() + "----------" + instance.getServiceId() + "-----------"
             + instance.getUri() + "-----------" + instance.getPort());
        }
        return this.discoveryClient;
    }

}
