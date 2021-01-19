package com.xiaofan.controller;

import com.xiaofan.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    public void hello() {
        asyncService.hello();
    }
}
