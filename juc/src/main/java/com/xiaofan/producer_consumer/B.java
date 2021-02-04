package com.xiaofan.producer_consumer;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程之间的通信问题： 生产者和消费者问题！ 等待环形， 通知唤醒
 * 线程交替执行   A B 操作同一个变量 num = 0
 * A num + 1
 * B num - 1
 */
public class B {
    public static void main(String[] args) {
        Data1 data1 = new Data1();
        new Thread(()->{ for (int i = 0; i < 10; i++) data1.increment(); }, "A").start();
        new Thread(()->{ for (int i = 0; i < 10; i++) data1.decrement(); }, "B").start();
        new Thread(()->{ for (int i = 0; i < 10; i++) data1.increment(); }, "C").start();
        new Thread(()->{ for (int i = 0; i < 10; i++) data1.decrement(); }, "D").start();

    }
}

// 判断等待， 业务， 通知
class Data1 {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //+1
    public void increment() {
        lock.lock();

        try{
            while (number != 0) {
                condition.await();
            }
            number ++;
            System.out.println(Thread.currentThread().getName() + " => " + number);
            // 通知其他线程， 我+1完毕了
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //-1
    public void decrement() {
        lock.lock();

        try {
            while (number == 0) {
                condition.await();
            }
            number --;
            System.out.println(Thread.currentThread().getName() + " => " + number);
            // 通知其他线程， 我+1完毕了
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}
