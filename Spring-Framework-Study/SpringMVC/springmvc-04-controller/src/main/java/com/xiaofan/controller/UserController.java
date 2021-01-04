package com.xiaofan.controller;

import com.xiaofan.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    // localhost:8080/user/t1?username=xxx
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model) {

        System.out.println("接收到的前端参数：" + name);

        model.addAttribute("msg", name);

        return "test";
    }

    // 接收一个对象 http://localhost:8080/springmvc_04_controller_war_exploded/user/t2?name=xiaofan&age=3&id=999
    @GetMapping("/t2")
    public String test2(User user, Model model) {

        System.out.println("接收到的前端参数：" + user);

        model.addAttribute("msg", user);

        return "test";
    }
}
