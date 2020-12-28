package com.xiaofan.dao;

public class UserMysqlImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("默认获取Mysql用户数据");
    }
}
