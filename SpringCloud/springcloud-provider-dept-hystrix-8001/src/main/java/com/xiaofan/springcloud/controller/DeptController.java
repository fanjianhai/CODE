package com.xiaofan.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiaofan.springcloud.pojo.Dept;
import com.xiaofan.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);

        if (dept == null) {
            throw new RuntimeException("id => " + id + "不存改在用户，或者信息无法找到");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable("id") Long id) {
       return new Dept(id, "empty", "empty");
    }


}
