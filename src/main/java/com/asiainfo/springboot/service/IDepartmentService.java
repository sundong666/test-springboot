package com.asiainfo.springboot.service;

import com.asiainfo.springboot.dto.DepartmentDto;
import com.asiainfo.springboot.model.Department;

import java.util.Collection;

public interface IDepartmentService {

    public Collection<DepartmentDto> getDepartments();

    public DepartmentDto getDepartmentById(Integer id);
}
