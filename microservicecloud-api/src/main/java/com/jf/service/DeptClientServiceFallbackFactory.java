package com.jf.service;

import com.jf.entity.Department;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潇潇暮雨
 * @create 2018-12-05   14:28
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Department department) {

                return false;
            }

            @Override
            public Department getDeptById(Integer id) {
                Department department = new Department();
                department.setDeptName("由于当前访问人数过多,对getDeptById进行了服务降级处理，请明天再来访问");
                return department;
            }

            @Override
            public List<Department> getAllDept() {
                List<Department> departments = new ArrayList<>();
                Department department = new Department();
                department.setDeptName("由于当前访问人数过多,对getDeptById进行了服务降级处理，请明天再来访问");
                departments.add(department);
                return departments;
            }
        };
    }
}
