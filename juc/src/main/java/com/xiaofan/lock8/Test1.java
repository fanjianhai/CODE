package com.xiaofan.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，就是关于锁的8个问题
 * 1. 标准情况下，两个线程先打印发短信还是打电话？        发短信
 * 2. sendSms延迟4秒，两个线程先打印发短信还是打电话？   发短信
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> { phone.sendSms(); }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> { phone.call(); }, "B").start();
    }
}


class Phone {

    // synchronized 锁的对象是方法的调用者，两个方法用的是同一个锁，谁先拿到谁执行
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }
}