package com.xiaofan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RouteController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "views/login";
    }

    @GetMapping("/level{suffix}/{id}")
    public String level(@PathVariable("suffix") Integer suffix, @PathVariable("id") Integer id) {
        return "views/level" + suffix + "/" + id;
    }

}
