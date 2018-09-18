package com.asiainfo.springboot.mapper;

import com.asiainfo.springboot.model.Department;

import java.util.Collection;


public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    Collection<Department> selectDepartments();
}