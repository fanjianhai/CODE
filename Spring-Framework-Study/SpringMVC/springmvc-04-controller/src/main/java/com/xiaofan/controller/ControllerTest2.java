package com.xiaofan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 一般不推荐这种写法
 */
@Controller
@RequestMapping("/t")
public class ControllerTest2 {

    @RequestMapping("/t1")
    public String test(Model model) {
        model.addAttribute("msg", "ControllerTest2");
        return "test";
    }
}
