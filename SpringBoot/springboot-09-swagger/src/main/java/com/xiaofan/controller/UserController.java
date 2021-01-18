package com.xiaofan.controller;

import com.xiaofan.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value="用户controller",tags={"用户操作接口"})
@RestController
public class UserController {
    @ApiOperation(value="获取用户信息")
    @GetMapping("/xiaofan/getUserInfo")
    public User getUserInfo(@ApiParam(name="id",value="用户id",required=true) Long id, @ApiParam(name="username",value="用户名") String username) {
        return new User();
    }

    @ApiOperation("更改用户信息")
    @PostMapping("/xiaofan/updateUserInfo")
    public int updateUserInfo(@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true) User user){
        return 999;
    }
}