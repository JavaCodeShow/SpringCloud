package com.jf.service;


import com.jf.entity.Department;

import java.util.List;

/**
 * @author 潇潇暮雨
 * @create 2018-12-01   20:24
 */

public interface DepartmentService {

    boolean addDept(Department department);

    Department findDeptById(Integer id);

    List<Department> findAllDept();
}
