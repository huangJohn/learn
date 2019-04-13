package com.zh.learn.concurrency_test.design.active_objects;//package concurrency.design.active_objects;
//
///**
// * @author zhuanghuang
// * @date 2018/10/10
// */
//
//public final class OrderServiceFactory {
//
//    //将ActiveMessage定义成static的目的是，保持其在整个JVM进程中唯一，并且ActiveDaemonThread会在此刻启动
//    private final static ActiveMessageQueue ACTIVE_MESSAGE_QUEUE = new ActiveMessageQueue();
//
//    //不允许外部通过new的方式构建
//    private OrderServiceFactory() {
//
//    }
//
//    //返回OrderServiceProxy
//    public static OrderService toActiveObject(OrderService orderService) {
//        return new OrderServiceProxy(orderService, ACTIVE_MESSAGE_QUEUE);
//    }
//
//}
