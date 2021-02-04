package com.xiaofan.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class VDemo {
    // volatile 不保证原子性
    // 原子类的Integer
    private static AtomicInteger num = new AtomicInteger();

    public static void add() {
        // num ++; 不是一个原子操作
        num.getAndIncrement();  // +1 , CAS
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while(Thread.activeCount() > 2) {   // main gc
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}
