package com.xiaofan.demo04;

import com.xiaofan.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 用这个类生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public void setRent(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    // 处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质：发射机制实现
        log("调用了方法 " + method.getName());
        Object result = method.invoke(target, args);
        return result;

    }

    public void log(String msg) {
        System.out.println(msg);
    }
}
