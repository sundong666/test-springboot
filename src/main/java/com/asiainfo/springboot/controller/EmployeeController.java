package com.asiainfo.springboot.controller;

import com.asiainfo.springboot.dao.DepartmentDao;
import com.asiainfo.springboot.dao.EmployeeDao;
import com.asiainfo.springboot.dto.DepartmentDto;
import com.asiainfo.springboot.dto.EmployeeDto;
import com.asiainfo.springboot.entities.Department;
import com.asiainfo.springboot.entities.Employee;
import com.asiainfo.springboot.service.IDepartmentService;
import com.asiainfo.springboot.service.IEmployeeService;
import com.asiainfo.springboot.service.impl.DepartmentServiceImpl;
import com.asiainfo.springboot.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
//    private EmployeeDao employeeDao;
    private IEmployeeService employeeDao;

    @Autowired
//    private DepartmentDao departmentDao;
    private IDepartmentService departmentDao;
    /**
     * 获取员工列表
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String getAllEmp(Model model) {
        Collection<EmployeeDto> emps = employeeDao.getAll();
        model.addAttribute("emps", emps);
        return "/emp/list";
    }

    /**
     * 员工添加页面
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<DepartmentDto> depts = departmentDao.getDepartments();
        model.addAttribute("depts", depts);
        return "/emp/add";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(EmployeeDto employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 员工编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        EmployeeDto emp = employeeDao.get(id);
        Collection<DepartmentDto> depts = departmentDao.getDepartments();
        model.addAttribute("emp", emp);
        model.addAttribute("depts", depts);
        return "/emp/add";
    }

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmp(EmployeeDto employee) {
        employeeDao.update(employee);
        return "redirect:/emps";
    }

    /**
     * 删除指定员工
     * @param id
     * @param model
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id, Model model) {
        employeeDao.delete(id);
        Collection<DepartmentDto> depts = departmentDao.getDepartments();
        model.addAttribute("depts", depts);
        return "redirect:/emps";
    }

    @GetMapping("/emp/signout")
    public String signout(HttpServletRequest request) {
        request.getSession().removeAttribute("userName");
        return "redirect:/login.html";
    }
}
