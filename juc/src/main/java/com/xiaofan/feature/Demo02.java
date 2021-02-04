package com.xiaofan.feature;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用 CompletableFuture
 * 异步执行
 * 成功回调
 * 失败回调
 */
public class Demo02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 有返回值的SupplyAsync 异步回调
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " supplyAsync => String");
//            int i = 1/0;
            return "1024";
        });

        System.out.println(future.whenComplete((t, u) -> {
            System.out.println("t=> " + t);     // t 正常的返回结果
            System.out.println("u=> " + u);     // u 错误信息
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return "500";
        }).get());

    }
}
