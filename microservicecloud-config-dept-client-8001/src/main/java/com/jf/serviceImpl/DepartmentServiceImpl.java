package com.jf.serviceImpl;

import com.jf.dao.DepartmentMapper;
import com.jf.entity.Department;
import com.jf.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 潇潇暮雨
 * @create 2018-12-01   20:50
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public boolean addDept(Department department) {
        return departmentMapper.addDept(department);
    }

    @Override
    public Department findDeptById(Integer id) {
        return departmentMapper.findDeptById(id);
    }

    @Override
    public List<Department> findAllDept() {
        return departmentMapper.findAllDept();
    }
}
