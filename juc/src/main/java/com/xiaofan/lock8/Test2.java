package com.xiaofan.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，就是关于锁的8个问题
 * 3. 增加了一个普通方法之后，先打印发短信还是打印hello？ 普通方法 hello
 */
public class Test2 {
    public static void main(String[] args) {
        Phone2 phone2 = new Phone2();
        new Thread(() -> { phone2.sendSms(); }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> { phone2.hello(); }, "B").start();
    }
}


class Phone2 {

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


    // 这里没有锁，不是同步方法，不受锁的影响
    public void hello() {
        System.out.println("hello");
    }
}