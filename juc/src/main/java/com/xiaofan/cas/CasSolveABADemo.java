package com.xiaofan.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CasSolveABADemo {

    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(1, 1);

    public static void main(String[] args) {
        // AtomicStampedReference 注意：如果泛型是一个包装类，注意对象的引用问题
        // 正常业务操作，这里面比较的都是一个个对象

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp(); // 获取版本号
            System.out.println("a1=> " + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("a2 => " + atomicStampedReference.compareAndSet(1, 2, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("a2 => " + atomicStampedReference.getStamp());

            System.out.println("a3 => " + atomicStampedReference.compareAndSet(2, 1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("a3 => " + atomicStampedReference.getStamp());

        }, "a").start();


        new Thread(()->{
            int stamp = atomicStampedReference.getStamp(); // 获取版本号
            System.out.println("b1=> " + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("b2 => " + atomicStampedReference.compareAndSet(1, 6, stamp, stamp + 1));
            System.out.println("b2 => " + atomicStampedReference.getStamp());
        }, "b").start();

    }
}
