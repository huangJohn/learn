package com.zh.learn.design_patterns.future;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-16
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {

        FutureService futureService = new FutureService();

        Future<String> future = futureService.submit(
                () -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "123";
                }, System.out::println
        );//asyn 10s

        System.out.println("do other 1....");
        System.out.println("do other 2....");
        //syn 2s
        try {
            TimeUnit.MILLISECONDS.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("do other 3....");

//        String s = future.get();
//        System.out.println(s);

    }

}
