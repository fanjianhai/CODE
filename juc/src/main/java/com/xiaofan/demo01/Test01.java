package com.xiaofan.demo01;

public class Test01 {
    public static void main(String[] args) {
        // 最大同时可以执行多个线程
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
