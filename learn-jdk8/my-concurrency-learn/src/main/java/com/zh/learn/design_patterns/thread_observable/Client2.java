package com.zh.learn.design_patterns.thread_observable;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 */
public class Client2 {

    public static void main(String[] args) {

        final TaskLifeCycle<String> taskLifeCycle = new TaskLifeCycle.EmptyTaskLifeCycle<String>() {

            @Override
            public void onStart(Thread thread) {
                System.out.println(thread.getName() + " 任务started");
            }

            @Override
            public void onRunning(Thread thread) {
                System.out.println(thread.getName() + " 任务开始running");
            }

            @Override
            public void onFinish(Thread thread, String result) {
                System.out.println("the result is = " + result + " thread info = " + thread.getName());
            }

            @Override
            public void onError(Thread thread, Exception ex) {

            }

        };

        Observable observable = new ObservableThread(taskLifeCycle, () -> {

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("i finished done.");
            return "123";
        });

        observable.start();

    }

}
