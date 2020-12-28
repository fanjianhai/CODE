package com.xiaofan.demo02;

public class Client {
    public static void main(String[] args) {
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(new UserServiceImpl());
        proxy.add();
        proxy.del();
    }
}
