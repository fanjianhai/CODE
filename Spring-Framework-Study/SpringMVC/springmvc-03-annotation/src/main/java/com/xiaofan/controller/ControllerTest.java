package com.xiaofan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {

    @RequestMapping("/test/t1")
    public String test(Model model) {

        model.addAttribute("msg", "controller test!!");

        return "hello";
    }
}
