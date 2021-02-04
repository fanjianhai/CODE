package com.xiaofan.function;

import java.util.function.Consumer;

/**
 * 消费型接口，没有返回值，只有参数
 */
public class Demo04 {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer.accept("xiaofan");
        //lambda表达式
        consumer = s -> System.out.println(s);
        consumer.accept("xiaofan");
    }
}
