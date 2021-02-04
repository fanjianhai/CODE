package com.xiaofan.demo01;

/**
 * 线程就是一个单独的资源类，没有任何复数的操作！
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        // 并发： 多线程操作同一个资源类， 把资源类丢入线程
        final Ticket ticket = new Ticket();

        // @FunctionalInterface 函数式接口, jdk1.8 lambda 表达式(参数)->{代码}
        new Thread(()->{ for (int i = 0; i < 11; i++) ticket.sale(); }, "A").start();
        new Thread(()->{ for (int i = 0; i < 31; i++) ticket.sale(); }, "B").start();
        new Thread(()->{ for (int i = 0; i < 31; i++) ticket.sale(); }, "C").start();
    }
}

// 资源类 OOP
class Ticket {
    // 属性，方法
    private int number = 30;

    // 卖票的方式
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票, 剩余票数：" + number);
        }
    }
}
