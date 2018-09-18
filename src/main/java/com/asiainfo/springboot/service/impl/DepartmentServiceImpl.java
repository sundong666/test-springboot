package com.asiainfo.springboot.service.impl;

import com.asiainfo.springboot.dto.DepartmentDto;
import com.asiainfo.springboot.mapper.DepartmentMapper;
import com.asiainfo.springboot.model.Department;
import com.asiainfo.springboot.service.IDepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;// 这里会报错，但是并不会影响

    @Override
    public Collection<DepartmentDto> getDepartments() {
        Collection<Department> departments = departmentMapper.selectDepartments();
        Collection<DepartmentDto> departmentDtos = new ArrayList<>();
        DepartmentDto departmentDto = null;
        for (Department department : departments) {
            departmentDto = new DepartmentDto();
            try {
                BeanUtils.copyProperties(department, departmentDto);
            } catch (Exception e) {
                e.printStackTrace();
            }
            departmentDtos.add(departmentDto);
        }
        return departmentDtos;
    }

    @Override
    public DepartmentDto getDepartmentById(Integer id) {
        Department department = departmentMapper.selectByPrimaryKey(id);
        DepartmentDto departmentDto = new DepartmentDto();
        try {
            BeanUtils.copyProperties(department, departmentDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentDto;
    }
}
