package com.xiaofan.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，就是关于锁的8个问题
 * 5. 增加两个静态的同步方法，只有一个对象，先打印发短信？打电话？        发短信
 * 6. 两个对象，增加两个静态的同步方法，先打印发短信？打电话？           发短信
 */
public class Test5 {
    public static void main(String[] args) {
        // 两个对象的类模板只有一个，而synchronized此时锁的就是Class模板
        Phone5 phone5_1 = new Phone5();
        Phone5 phone5_2 = new Phone5();
        new Thread(() -> { phone5_1.sendSms(); }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> { phone5_2.call(); }, "B").start();
    }
}

// Phone5 唯一的一个class对象
class Phone5 {

    // synchronized 锁的对象是方法的调用者，两个方法用的是同一个锁，谁先拿到谁执行
    // static 静态方法 synchronized 锁的是Class模板对象
    // 类一加载就有了！ Class模板
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }
}