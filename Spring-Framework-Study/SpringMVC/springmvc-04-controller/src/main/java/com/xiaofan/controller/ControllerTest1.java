package com.xiaofan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest1 {

    @RequestMapping("/t1")
    public String test1(Model model) {
        model.addAttribute("msg", "ControllerTest1");
        return "test";
    }
}
