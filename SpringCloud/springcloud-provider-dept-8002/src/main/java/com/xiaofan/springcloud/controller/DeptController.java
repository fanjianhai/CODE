package com.xiaofan.springcloud.controller;


import com.netflix.discovery.converters.Auto;
import com.xiaofan.springcloud.pojo.Dept;
import com.xiaofan.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DiscoveryClient client;

    @Autowired
    DeptService deptService;

    @RequestMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    // 注册进来的微服务，查看一些信息
    @RequestMapping("/dept/discovery")
    public Object discovery() {
        List<String> services = client.getServices();
        System.out.println("discover=>services: " + services);

        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId() + "\t");
        }

        return client;
    }




}
