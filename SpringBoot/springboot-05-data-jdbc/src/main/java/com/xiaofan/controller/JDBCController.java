package com.xiaofan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userlist")
    public List<Map<String, Object>> userList() {
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/adduser")
    public String addUser() {
        String sql = "insert into mybatis.user(id, name, pwd) values(3,'小范','123456')";
        jdbcTemplate.update(sql);
        return "add-ok";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Integer id) {
        String sql = "update mybatis.user set name=?, pwd=? where id=" + id;
        // 封装
        Object[] objects = new Object[2];
        objects[0] = "雪山飞狐";
        objects[1] = "1314520";
        jdbcTemplate.update(sql, objects);
        return "update-ok";
    }

    @GetMapping("/delUser/{id}")
    public String delUser(@PathVariable("id") Integer id) {
        String sql = "delete from mybatis.user where id =? ";
        jdbcTemplate.update(sql, id);
        return "delete-ok";
    }

}
