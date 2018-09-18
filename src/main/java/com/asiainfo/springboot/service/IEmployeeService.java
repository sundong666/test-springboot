package com.asiainfo.springboot.service;

import com.asiainfo.springboot.dto.EmployeeDto;
import com.asiainfo.springboot.model.Employee;

import java.util.Collection;

public interface IEmployeeService {

    public void save(EmployeeDto employeeDto);

    public void update(EmployeeDto employeeDto);

    public Collection<EmployeeDto> getAll();

    public EmployeeDto get(Integer id);

    public void delete(Integer id);
}
