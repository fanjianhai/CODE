package com.xiaofan.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 用这个类生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    // 处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质：发射机制实现
        seeHouse();
        Object result = method.invoke(rent, args);
        fare();
        return result;

    }

    public void seeHouse() {
        System.out.println("中介带着你看房子");
    }

    public void fare() {
        System.out.println("中介收费");
    }
}
