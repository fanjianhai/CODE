package com.xiaofan.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 加法计数器
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        /**
         * 集齐7颗龙珠召唤神龙
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙成功！");
        });

        for (int i = 1; i <= 7; i++) {
            int temp = i;
            // Lambda 操作不到i
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "收集" + temp + " 个龙珠");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (Exception e) {

                }
                // 在执行玩召唤神龙方法之后，每个子线程继续“不确定顺序”执行
                System.out.println(Thread.currentThread().getName() + "continue...");
            }).start();
        }
    }
}
