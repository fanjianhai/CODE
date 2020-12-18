package com.xiaofan.dao;

import com.xiaofan.pojo.User;
import com.xiaofan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void testQueryUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        System.out.println("===============");

        User user1 = mapper.getUserById(1);
        System.out.println(user1);

        System.out.println(user == user1);
        sqlSession.close();
    }

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();

        sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper1 = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper1.getUserById(1);

        System.out.println(user == user1);

    }
}
