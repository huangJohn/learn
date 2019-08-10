package com.zh.learn.design_patterns.two_phase_termination;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-10
 */
public class CaptureThreadException {

    public static void main(String[] args) {

        //全局设置异常回调
        //线程执行单元不允许抛出checked异常的
        //线程运行在自己的上下文中，派生它的线程将无法直接获得它运行中出现的异常
        //java提供UncaughtExceptionHandler接口，在线程出现异常时回调通知，得知哪个线程出现异常信息
        Thread.setDefaultUncaughtExceptionHandler((t,e)->{
            System.out.println(t.getName() + " 发生 exception");
            e.printStackTrace();
        });

        //会向tread group查找UncaughtExceptionHandler，最终还是全局设置回调，没有则堆栈信息定向到System.err中
        final Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {

            }

            //出现unchecked异常
            System.out.println(1 / 0);
        });
        thread.start();
    }

}
