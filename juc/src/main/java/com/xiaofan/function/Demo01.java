package com.xiaofan.function;

import java.util.function.Function;

/**
 * Function 函数型接口，有一个输入参数，一个输出参数
 * 函数型接口，可以用 lambda表达式简化
 */
public class Demo01 {
    public static void main(String[] args) {
        Function<String, String> function = new Function<String, String>() {

            @Override
            public String apply(String str) {
                return str;
            }
        };

        System.out.println(function.apply("fanfan"));

        // lambda表达式
        function = str -> str;
        System.out.println(function.apply("xiaofan"));


    }
}
