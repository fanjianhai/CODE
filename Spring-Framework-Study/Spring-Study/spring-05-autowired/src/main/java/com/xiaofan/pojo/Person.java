package com.xiaofan.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class Person {

    private String name;

    @Autowired
    @Qualifier(value = "dog111")
    private Dog dog;

    @Resource(name = "cat22")
    private Cat cat;

    public String getName() {
        return name;
    }

    public Dog getDog() {
        return dog;
    }


    public Cat getCat() {
        return cat;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                ", cat=" + cat +
                '}';
    }
}
