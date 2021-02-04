package com.xiaofan.pool;

import java.util.concurrent.*;

/**
 * 线程池的最大数设置
 * 1. CPU密集型，几核，就是几，可以保持CPU的效率最高！
 * 2. IO密集型，大于判断程序中十分耗IO的线程数，一半2倍即可
 */
public class Demo03 {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        try {
            for (int i = 0; i < 10; i++) {
                // 使用了线程池之后，使用线程池来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " ok");
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }
}
