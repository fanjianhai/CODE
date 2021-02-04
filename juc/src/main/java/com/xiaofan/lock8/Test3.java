package com.xiaofan.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，就是关于锁的8个问题
 * 4. 两个对象，两个同步方法， 发短信还是打电话？ 打电话
 */
public class Test3 {
    public static void main(String[] args) {
        Phone3 phone3_1 = new Phone3();
        Phone3 phone3_2 = new Phone3();
        new Thread(() -> { phone3_1.sendSms(); }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> { phone3_2.call(); }, "B").start();
    }
}


class Phone3 {

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