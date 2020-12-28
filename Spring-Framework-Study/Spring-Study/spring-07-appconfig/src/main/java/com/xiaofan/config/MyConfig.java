package com.xiaofan.config;

import com.xiaofan.pojo.Person;
import com.xiaofan.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xiaofan.pojo")
public class MyConfig {

    @Bean
    public Person getPerson() {
        return new Person();
    }
}
