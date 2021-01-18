package com.xiaofan.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping({"/", "/index", "index.html"})
    public String toIndex(Model model) {
        model.addAttribute("msg", "hello shiro!");
        return "index";
    }

    @GetMapping("/user/add")
    public String toADD() {
        return "user/add";
    }

    @GetMapping("/user/update")
    public String toUpdate() {
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            // 用户名不存在
            model.addAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            // 密码错误
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthronize() {
        return "胃镜授权无法访问此页面！";
    }
}
