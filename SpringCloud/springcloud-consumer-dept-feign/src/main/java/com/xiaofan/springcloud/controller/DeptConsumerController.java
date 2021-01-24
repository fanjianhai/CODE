package com.xiaofan.springcloud.controller;

import com.xiaofan.springcloud.pojo.Dept;
import com.xiaofan.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    DeptClientService deptClientService;


    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.queryById(id);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add (Dept dept) {
        return deptClientService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {

        return deptClientService.queryAll();
    }
}
