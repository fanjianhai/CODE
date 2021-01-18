package com.xiaofan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class HelloController {

    @GetMapping("/test")
    public String hello(Model model) {
        model.addAttribute("msg", "<h1>hello springboot!</h1>");
        model.addAttribute("users", Arrays.asList("中国", "美国", "日本"));
        return "test";
    }
}
