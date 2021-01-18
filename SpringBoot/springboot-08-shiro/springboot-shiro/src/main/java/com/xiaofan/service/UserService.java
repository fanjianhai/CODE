package com.xiaofan.service;

import com.xiaofan.pojo.User;

import java.util.List;

public interface UserService {

    List<User> queryUserList();

    User queryUserById(int id);

    User queryUserByName(String name);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
