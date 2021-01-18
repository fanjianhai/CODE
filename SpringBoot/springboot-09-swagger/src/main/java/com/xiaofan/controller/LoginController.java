package com.xiaofan.controller;

import com.xiaofan.pojo.Teacher;
import com.xiaofan.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value="登录controller",tags={"登录/登出操作接口"})
@RestController
public class LoginController {

    @ApiOperation("登录")
    @PostMapping("/xiaofan/teacher")
    public Teacher login(@RequestBody  Teacher teacher){
        return teacher;
    }
}