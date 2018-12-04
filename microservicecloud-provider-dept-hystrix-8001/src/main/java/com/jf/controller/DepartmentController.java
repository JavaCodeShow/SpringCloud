package com.jf.controller;

import com.jf.entity.Department;
import com.jf.service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    // 一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "getDeptByIdFallback")
    @GetMapping(value = "/dept/get/{id}")
    public Department getDeptById(@PathVariable("id") Integer id) {
        Department department = departmentService.findDeptById(id);
        if (department == null){
            throw new RuntimeException("数据库中没有id号为：" + id + "的数据");
        }
        return department;
    }

    public Department getDeptByIdFallback(@PathVariable("id") Integer id) {
        System.out.println("调用了getDeptByIdFallback 这个方法");
        System.out.println("调用了getDeptByIdFallback 这个方法");
        System.out.println("调用了getDeptByIdFallback 这个方法");
        Department department = new Department();
        department.setDeptName("熔断");
        return department;
    }


    @GetMapping(value = "/dept/get/list")
    public List<Department> getAllDept() {
        return departmentService.findAllDept();
    }

    @GetMapping(value = "/dept/discovery")
    public DiscoveryClient discovery() {
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
