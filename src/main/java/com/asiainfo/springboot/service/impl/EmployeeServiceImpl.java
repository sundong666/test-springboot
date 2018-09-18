package com.asiainfo.springboot.service.impl;

import com.asiainfo.springboot.dto.EmployeeDto;
import com.asiainfo.springboot.mapper.DepartmentMapper;
import com.asiainfo.springboot.mapper.EmployeeMapper;
import com.asiainfo.springboot.model.Department;
import com.asiainfo.springboot.model.Employee;
import com.asiainfo.springboot.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void update(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        try {
            BeanUtils.copyProperties(employeeDto, employee, "department");
        } catch (Exception e) {
            e.printStackTrace();
        }
        employee.setDeptId(employeeDto.getDepartment().getId());
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    @Override
    public void save(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        try {
            BeanUtils.copyProperties(employeeDto, employee, "department");
        } catch (Exception e) {
            e.printStackTrace();
        }
        employee.setDeptId(employeeDto.getDepartment().getId());
        employeeMapper.insert(employee);
    }

    @Override
    public Collection<EmployeeDto> getAll() {
        Collection<Employee> emps = employeeMapper.selectAllEmployees();
        Collection<EmployeeDto> employeeDtos = new ArrayList<>();
        EmployeeDto employeeDto = null;
        Department department = null;
        for (Employee emp : emps) {
            employeeDto = new EmployeeDto();
            try {
                BeanUtils.copyProperties(emp, employeeDto, "deptId");
            } catch (Exception e) {
                e.printStackTrace();
            }
            department = departmentMapper.selectByPrimaryKey(emp.getDeptId());
            employeeDto.setDepartment(department);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public EmployeeDto get(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        EmployeeDto employeeDto = new EmployeeDto();
        Department department = departmentMapper.selectByPrimaryKey(employee.getDeptId());
        try {
            BeanUtils.copyProperties(employee, employeeDto, "deptId");
        } catch (Exception e) {
            e.printStackTrace();
        }
        employeeDto.setDepartment(department);
    return employeeDto;
    }

    @Override
    public void delete(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }
}
