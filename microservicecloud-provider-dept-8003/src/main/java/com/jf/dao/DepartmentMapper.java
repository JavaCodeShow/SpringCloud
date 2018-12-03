package com.jf.dao;

import com.jf.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 潇潇暮雨
 * @create 2018-12-01   20:22
 */
@Mapper
public interface DepartmentMapper {

    boolean addDept(Department department);

    Department findDeptById(Integer id);

    List<Department> findAllDept();
}
