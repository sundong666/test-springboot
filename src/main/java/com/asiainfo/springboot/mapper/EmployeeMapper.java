package com.asiainfo.springboot.mapper;

import com.asiainfo.springboot.model.Employee;

import java.util.Collection;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Collection<Employee> selectAllEmployees();
}