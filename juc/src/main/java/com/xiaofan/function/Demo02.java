package com.xiaofan.function;

import java.util.function.Predicate;

/**
 * 断定型接口：一个输入参数，返回值只能是boolean
 */
public class Demo02 {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<String>() {

            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };

        System.out.println(predicate.test(""));

        // lambda表达式
        predicate = str -> str.isEmpty();
        System.out.println(predicate.test("fanfan"));


    }
}
