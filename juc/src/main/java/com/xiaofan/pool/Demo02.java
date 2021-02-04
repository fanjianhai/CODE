package com.xiaofan.pool;

import java.util.concurrent.*;

/**
 * 自定义线程池
 * 没有线程可用的时候（阻塞队列也没有了，就启动拒绝策略）
 * 1.new ThreadPoolExecutor.AbortPolicy()   线程池不够用了，还有任务，就抛出异常
 * 2.new ThreadPoolExecutor.CallerRunsPolicy()  哪来的哪去
 * 3.new ThreadPoolExecutor.DiscardPolicy()   队列满了，丢掉任务，不会抛出异常
 * 4.new ThreadPoolExecutor.DiscardOldestPolicy()   队列满了，尝试和最早的竞争，也不会抛出异常
 */
public class Demo02 {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,  // 空闲线程存活时间
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        try {
            for (int i = 0; i < 10; i++) {
                // 使用了线程池之后，使用线程池来创建线程
//                threadPool.execute(()->{
//                    System.out.println(Thread.currentThread().getName() + " ok");
//                });

                threadPool.execute(new MyTask(i, String.valueOf(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }
}

class MyTask implements Runnable {

    private int taskId;
    private String taskName;

    public MyTask(int taskId, String taskName){
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("ID: " + this.taskId + " NAME: "+Thread.currentThread().getName() + " ok");
    }

    public String toString(){
        return Integer.toString(this.taskId);
    }

}

