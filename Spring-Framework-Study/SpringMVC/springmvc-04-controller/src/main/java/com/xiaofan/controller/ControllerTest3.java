package com.xiaofan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 一般不推荐这种写法
 */
@Controller
public class ControllerTest3 {

    @RequestMapping("/t3/t1")
    public String test(Model model) {
        model.addAttribute("msg", "ControllerTest3");
        return "test";
    }
}
