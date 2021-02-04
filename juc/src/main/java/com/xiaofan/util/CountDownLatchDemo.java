package com.xiaofan.util;

import java.util.concurrent.CountDownLatch;

/**
 * 减法计数器
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 总数是6，必须要执行任务的时候，再使用！
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " go out...");
                countDownLatch.countDown();     // 数量减1
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();     // 等待计数归零，再继续向下执行
        // 继续回到主线程执行
        System.out.println(Thread.currentThread().getName() + "close door...");
    }
}
