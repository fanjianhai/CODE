package com.xiaofan.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁（写锁） 一次只能被一个线程占有
 * 共享锁（读锁） 多个线程可以同时占有
 * ReadWriteLock
 * 读-读  可以共存！
 * 读-写  不能共存！
 * 写-写  不能共存！
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
//        MyCache myCache = new MyCache();
        MyCacheLock myCacheLock = new MyCacheLock();

        for (int i = 1; i <= 5; i++) {
            int temp = i;
            new Thread(()->{
                myCacheLock.put(String.valueOf(temp), String.valueOf(temp));
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            int temp = i;
            new Thread(()->{
                myCacheLock.get(String.valueOf(temp));
            }, String.valueOf(i)).start();
        }
    }
}

/**
 * 自定义缓存
 */
class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();

    // 存， 写
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() +" 写入 " + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() +" 写入完毕！");
    }

    // 取，读
    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + " 读取 " + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + " 读取完毕！");
    }
}

/**
 * 加锁的自定义缓存
 */
class MyCacheLock {

    private volatile Map<String, Object> map = new HashMap<>();
    // 读写锁，更加细粒度的控制
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 存， 写入的时候
    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() +" 写入 " + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() +" 写入完毕！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    // 取，读
    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 读取 " + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取完毕！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}