package com.zh.learn.design_patterns.future;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 */
public class SyncInvoker {

    public static void main(String[] args) {
        String s = get();
        //10s
        System.out.println(s);
    }

    private static String get() {
        try {
            TimeUnit.MILLISECONDS.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "123";
    }

}
