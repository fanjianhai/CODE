package com.xiaofan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTest4 {

    @GetMapping("/t4")
    public String test(Model model) {
        model.addAttribute("msg", "ControllerTest4");
        return "redirect:/a.jsp";
    }
}
