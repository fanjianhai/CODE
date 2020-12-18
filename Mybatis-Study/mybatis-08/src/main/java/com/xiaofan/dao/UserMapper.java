package com.xiaofan.dao;

import com.xiaofan.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUserById(@Param("id") int id);

}
