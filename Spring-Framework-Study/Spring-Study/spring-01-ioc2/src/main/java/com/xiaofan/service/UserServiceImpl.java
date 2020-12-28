package com.xiaofan.service;

import com.xiaofan.dao.UserDao;

public class UserServiceImpl implements UserService{

    private UserDao dao ;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void getUser() {
        dao.getUser();
    }
}
