package com.xiaofan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringCloudZuul {
    // 测试通过 http://www.xiaofanstudy.com:9527/fan/mydept/dept/get/1
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuul.class, args);
    }
}
