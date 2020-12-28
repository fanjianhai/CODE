package com.xiaofan.demo04;

import com.xiaofan.demo02.UserService;
import com.xiaofan.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        pih.setRent(userService);

        UserService proxy = (UserService) pih.getProxy();

        proxy.add();

        proxy.del();
    }
}
