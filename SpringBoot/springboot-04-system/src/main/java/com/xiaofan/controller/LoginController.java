package com.xiaofan.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {

        if (!Strings.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser", username);
            //重定向到main.html页面,也就是跳转到dashboard页面
            return "redirect:/main.html";
        } else{
            model.addAttribute("msg", "用户名或者密码错误");//显示错误信息
            return "index";//跳转到首页
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }
}
