package com.xiaofan.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        // 并发： 多线程操作同一个资源类， 把资源类丢入线程
        final Ticket2 ticket2 = new Ticket2();

        // @FunctionalInterface 函数式接口, jdk1.8 lambda 表达式(参数)->{代码}
        new Thread(()->{ for (int i = 0; i < 31; i++) ticket2.sale(); }, "A").start();
        new Thread(()->{ for (int i = 0; i < 31; i++) ticket2.sale(); }, "B").start();
        new Thread(()->{ for (int i = 0; i < 31; i++) ticket2.sale(); }, "C").start();

    }
}

// Lock三部曲
// 1. new ReentrantLock();
// 2. lock.lock();
// 3. lock.unlock(); 解锁
class Ticket2 {
    // 属性，方法
    private int number = 30;

    private Lock lock = new ReentrantLock();

    // 卖票的方式
    public void sale() {
        lock.lock();

        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票, 剩余票数：" + number);
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
