package com.xiaofan.dao;

import com.xiaofan.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();//创建一个部门表
        departments.put(1, new Department(1, "技术部"));
        departments.put(2, new Department(2, "市场部"));
        departments.put(3, new Department(3, "调研部"));
        departments.put(4, new Department(4, "后勤部"));
        departments.put(5, new Department(5, "运营部"));
    }

    //获得部门的所有信息
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    //通过id得到部门
    public Department getDepartmentById(int id) {
        return departments.get(id);
    }
}