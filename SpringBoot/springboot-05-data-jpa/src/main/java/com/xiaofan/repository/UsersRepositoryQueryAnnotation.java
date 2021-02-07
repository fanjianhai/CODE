package com.xiaofan.repository;

import com.xiaofan.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *  Repository    @Query
 *
 * @author admin
 * @create 2019/5/22
 * @since 1.0.0
 */
public interface UsersRepositoryQueryAnnotation extends JpaRepository<Users,Integer> {

    @Query(value = "from Users where name = ?1")
    List<Users> queryByNameUseHQL(String name);

    @Query(value = "select * from t_users where name=?",nativeQuery = true)
    List<Users> queryByNameUseSQL(String name);

    @Query("update Users set name=?1 where id=?2")
    @Modifying  //需要执行一个更新操作
    void updateUsersNameById(String name,Integer id);

}

