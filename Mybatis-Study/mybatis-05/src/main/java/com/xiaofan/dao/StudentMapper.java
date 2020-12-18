package com.xiaofan.dao;

import com.xiaofan.pojo.Student;
import com.xiaofan.pojo.Teacher;

import java.util.List;

public interface StudentMapper {

    // 查询所有的学生信息，以及对应的老师的信息
    public List<Student> getStudent1();

    public List<Student> getStudent2();
}
