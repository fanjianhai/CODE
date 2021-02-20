package com.xiaofan.pojo;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private Long id;
    private String name;
    private String email;
    private Date birthday;
    private User user;
}
