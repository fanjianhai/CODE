package com.xiaofan.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 求和计算的任务！
 * 3000 6000(ForkJoin) 9000(Stream并行流)
 * 如何使用forkjoin
 * 1. ForkjoinPool 通过它来执行
 * 2. 计算任务forkjoinPool.execute(ForkJoinTask task)
 * 3. 计算类要继承ForkJoinTask
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;
    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // forkjoin递归
            Long middle = (start + end) /2;
            // 拆分任务，把任务亚茹线程队列
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();
            // 拆分任务，把任务亚茹线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task2.fork();

            return task1.join() + task2.join();
        }
    }
}
