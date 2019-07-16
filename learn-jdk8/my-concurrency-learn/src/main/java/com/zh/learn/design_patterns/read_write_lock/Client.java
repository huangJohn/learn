package com.zh.learn.design_patterns.read_write_lock;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-16
 */
public class Client {

    public static void main(String[] args) {

        final SharedData data = new SharedData(10);

        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();

        new WriterWorker(data,"abc").start();
        new WriterWorker(data,"xyz").start();
    }

}
