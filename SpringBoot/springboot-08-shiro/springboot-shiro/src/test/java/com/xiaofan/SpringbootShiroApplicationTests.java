package com.xiaofan;

import com.xiaofan.pojo.User;
import com.xiaofan.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootShiroApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user = userService.queryUserByName("xiaofan");
        System.out.println(user);
    }

}
