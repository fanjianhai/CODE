package com.xiaofan.controller;

import com.alibaba.fastjson.JSON;
import com.xiaofan.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController  // 不会解析，只会返回字符串(前后端分离)
public class UserController {

    @RequestMapping("/j1")
    // @ResponseBody   // 他就不会走视图解析器，会直接返回一个字符串
    public String json1() {

        List<User> userList = new ArrayList<>();
        User user1 = new User("小范1号", 18, "男");
        User user2 = new User("小范2号", 19, "男");
        User user3 = new User("小范3号", 20, "男");
        User user4 = new User("小范4号", 21, "男");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        return JSON.toJSONString(userList);
    }
}
