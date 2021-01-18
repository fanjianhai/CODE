package com.xiaofan.controller;

import com.xiaofan.dao.DepartmentDao;
import com.xiaofan.dao.EmployeeDao;
import com.xiaofan.pojo.Department;
import com.xiaofan.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAllEmployees();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toADDpage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        // 添加的操作
        System.out.println("=========<>" + employee);
        employeeDao.addEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
        // 查询原来的数据进行修改
        Employee employee = employeeDao.getEmployeeByID(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);

        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeDao.addEmployee(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/delemp/{id}")
    public String delEmp(@PathVariable("id") Integer id) {
        employeeDao.deleteEmployeeByID(id);
        return "redirect:/emps";
    }


}
