package com.xiaofan.dao;

import com.xiaofan.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getUserById(int id);

    List<User> getUserByLimit(Map<String, Object> map);

}
