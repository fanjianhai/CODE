package com.xiaofan.dao;

import com.xiaofan.pojo.Department;
import com.xiaofan.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据库中员工表的数据
    static private Map<Integer, Employee> employees;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();//创建一个员工表
        employees.put(1, new Employee(1, "zsr", "1234@qq.com", 1, new Department(1, "技术部"), new Date()));
        employees.put(2, new Employee(2, "lyr", "1345@qq.com", 1, new Department(2, "市场部"), new Date()));
        employees.put(3, new Employee(3, "gcc", "5665@qq.com", 0, new Department(3, "调研部"), new Date()));
        employees.put(4, new Employee(4, "zyx", "7688@qq.com", 1, new Department(4, "后勤部"), new Date()));
        employees.put(5, new Employee(5, "zch", "8089@qq.com", 1, new Department(5, "运营部"), new Date()));
    }

    //主键自增
    private static Integer initialID = 6;

    //增加一个员工
    public void addEmployee(Employee employee) {
        if (employee.getId() == null)
            employee.setId(initialID++);
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeByID(Integer id) {
        return employees.get(id);
    }

    //通过id删除员工
    public void deleteEmployeeByID(int id) {
        employees.remove(id);
    }
}