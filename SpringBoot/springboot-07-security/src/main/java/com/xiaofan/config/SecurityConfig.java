package com.xiaofan.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// AOP: 拦截器！
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人可以访问， 功能页只有对应权限的人才能访问
        // 请求授权规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 没有权限，默认会到登录页面, 定制login页面 注意这里的链接和login.html表单中的做成一直就可以
        http.formLogin().loginPage("/toLogin");
        // 开启了注销功能

        http.csrf().disable();  // 防止跨域攻击csrf  springsecurity5不加也没报错
        http.logout().logoutSuccessUrl("/");

        // 开启记住我功能, 默认两周时间, 自定义接收前端的参数
        http.rememberMe().rememberMeParameter("remember");
    }

    // 认证, springboot 2.1.x 可以直接使用
    // 密码编码： PasswordEncoder
    // 在Spring Security 5.0 + 增加了很多加密的方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("xiaofan").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2", "vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
