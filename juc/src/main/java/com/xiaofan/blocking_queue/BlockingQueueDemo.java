package com.xiaofan.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    /**
     * 抛出异常
     */
    public static void test1() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.add(1));
        System.out.println(arrayBlockingQueue.add(2));
        System.out.println(arrayBlockingQueue.add(3));

        // java.lang.IllegalStateException: Queue full
        // System.out.println(arrayBlockingQueue.add(4));
        // 判断队首元素
        System.out.println(arrayBlockingQueue.element());

        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        // java.util.NoSuchElementException
        // System.out.println(arrayBlockingQueue.remove());

    }

    /**
     * 不抛出异常
     */
    public static void test2() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer(1));
        System.out.println(arrayBlockingQueue.offer(2));
        System.out.println(arrayBlockingQueue.offer(3));

         System.out.println(arrayBlockingQueue.offer(4));

        // 判断队首元素
        System.out.println(arrayBlockingQueue.peek());

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        // java.util.NoSuchElementException
        // System.out.println(arrayBlockingQueue.remove());

    }

    /**
     * 等待阻塞(一直阻塞)
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.put(1);
        arrayBlockingQueue.put(2);
        arrayBlockingQueue.put(3);
        // 等待阻塞，一直阻塞，直到放进去位置
        // arrayBlockingQueue.put(4);

        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        // 等待阻塞，一直阻塞，直到取到元素为止
        System.out.println(arrayBlockingQueue.take());

    }

    /**
     * 等待阻塞(超时等待)
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer(1));
        System.out.println(arrayBlockingQueue.offer(2));
        System.out.println(arrayBlockingQueue.offer(3));
        // 超过3秒钟后则产生结果
        System.out.println(arrayBlockingQueue.offer(4, 3, TimeUnit.SECONDS));

        // 判断队首元素
        System.out.println(arrayBlockingQueue.peek());

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll(3, TimeUnit.SECONDS));


    }
}
