package com.xiaofan.producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程轮流打印 A-B-C
 */
public class C {
    public static void main(String[] args) {
        Data3 data3 = new Data3();

        new Thread(()->{ for (int i = 0; i < 10; i++) data3.printA();}, "线程1").start();
        new Thread(()->{ for (int i = 0; i < 10; i++) data3.printB();}, "线程2").start();
        new Thread(()->{ for (int i = 0; i < 10; i++) data3.printC();}, "线程3").start();
    }
}


class Data3 {

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int number = 1;  // 1A 2B 3C

    public void printA() {
        lock.lock();

        try {
            // 业务-判断-执行-通知
            while(number != 1) {
                condition1.await();
            }
            number = 2;
            System.out.println(Thread.currentThread().getName() + "=> A...");
            // 唤醒指定的人
            condition2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void printB() {
        lock.lock();

        try {
            // 业务-判断-执行-通知
            while(number != 2) {
                condition2.await();
            }
            number = 3;
            System.out.println(Thread.currentThread().getName() + "=> B...");
            condition3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();

        try {
            // 业务-判断-执行-通知
            while(number != 3) {
                condition3.await();
            }
            number = 1;
            System.out.println(Thread.currentThread().getName() + "=> C...");
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
