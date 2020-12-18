package com.xiaofan.dao;

import com.xiaofan.pojo.User;
import com.xiaofan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoTest {

    private final static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testGetUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", 3);
        map.put("count", 2);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUserByLimit(map);

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void testLog() {
        logger.info("info...");
        logger.debug("debug...");
        logger.error("error...");
    }


}
