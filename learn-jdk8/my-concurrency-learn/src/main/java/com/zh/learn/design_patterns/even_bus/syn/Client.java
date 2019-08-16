package com.zh.learn.design_patterns.even_bus.syn;

import com.zh.learn.design_patterns.even_bus.Bus;
import com.zh.learn.design_patterns.even_bus.async.AsyncEventBus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class Client {

    public static void main(String[] args) {

        Bus bus = new EventBus(new EventExceptionHandlerImpl());
        bus.register(new SimpleObj());
        bus.register(new SimpleObj2());
        bus.post("hello");
        System.out.println("-----------------------");
        bus.post("world", "2-topic");
        System.out.println("------------------------");
        bus.post("123","123");
        bus.close();
        System.out.println("------------------------");

        bus = new AsyncEventBus(new EventExceptionHandlerImpl(), (ThreadPoolExecutor) Executors.newFixedThreadPool(10));
        bus.register(new SimpleObj());
        bus.register(new SimpleObj2());
        bus.post("hello");
        System.out.println("-----------------------");
        bus.post("world", "2-topic");
        System.out.println("------------------------");
        bus.post("123","123");
        bus.close();
    }

}
