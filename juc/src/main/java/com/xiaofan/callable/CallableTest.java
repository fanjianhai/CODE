package com.xiaofan.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 注意：同一个FutureTask下有复用情况
        FutureTask<String> futureTask1 = new FutureTask<>(new MyThread());
        FutureTask<String> futureTask2 = new FutureTask<>(new MyThread());
        new Thread(futureTask1, "A").start();
        new Thread(futureTask2, "B").start();    // 结果会被缓存，效率高

        String result1 = futureTask1.get();       // 这个方法可能会产生阻塞，把他放到最后，或者使用异步通信来处理
        System.out.println(result1);

        String result2 = futureTask1.get();
        System.out.println(result2);
    }
}


class MyThread implements Callable<String> {

    @Override
    public String call() {
        System.out.println(Thread.currentThread().getName() + " call...");
        return "1024";
    }
}
