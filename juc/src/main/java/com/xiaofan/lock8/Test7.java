package com.xiaofan.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，就是关于锁的8个问题
 * 8. 1个静态的同步方法， 1个普通的同步方法，两个个对象，先打印发短信？打电话？     打电话
 */
public class Test7 {
    public static void main(String[] args) {
        // 两个对象的类模板只有一个，而synchronized此时锁的就是Class模板
        Phone7 phone7_1 = new Phone7();
        Phone7 phone7_2 = new Phone7();
        new Thread(() -> { phone7_1.sendSms(); }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> { phone7_2.call(); }, "B").start();
    }
}

class Phone7 {

    // 静态的同步方法，锁的是Class类模板
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    // 普通的同步方法， 锁的是调用者
    public  synchronized void call() {
        System.out.println("打电话");
    }
}