package com.xiaofan.springboot05dataredis;

import com.xiaofan.springboot05dataredis.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05DataRedisApplicationTests {

    @Autowired
    RedisUtil redisUtil;

    @Test
    void contextLoads() {
        redisUtil.set("xiaohai", "小海");
        System.out.println(redisUtil.get("xiaohai"));
    }

}
