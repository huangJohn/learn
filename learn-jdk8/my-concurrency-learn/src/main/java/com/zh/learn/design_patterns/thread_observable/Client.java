package com.zh.learn.design_patterns.thread_observable;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 */
public class Client {

    public static void main(String[] args) {


        Observable observable = new ObservableThread(()->{

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("i finished done.");
            return null;
        });

        observable.start();
    }

}
