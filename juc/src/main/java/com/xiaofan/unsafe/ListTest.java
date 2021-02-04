package com.xiaofan.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

// java.util.ConcurrentModificationException    并发修改异常！
public class ListTest {
    public static void main(String[] args) {
        // 单线程安全
        /*List<String> list = Arrays.asList("1", "2", "3");
        list.forEach(System.out::println);*/

        // 并发下ArrayList不安全的吗？synchronized：
        /**
         * 解决方案：
         * 1. List<String> list = new Vector<>();   Vector是1.0出来的，List是1.2出来的
         * 2. List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3. List<String> list = new CopyOnWriteArrayList<>();
         */
        // CopyOnWrite 写入时复制 COW 计算机程序设计的一种优化策略
        // 多个线程调用的时候，list读取的时候，固定的，写入（覆盖）， 在写入的时候避免覆盖，造成数据问题！读写分离
        // CopyOnWriteArrayList 比 Vector牛逼的地方是底层应用了Lock锁，而Vector应用了synchronized
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
