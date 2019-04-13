package com.zh.learn.concurrency_test.design.active_objects;//package concurrency.design.active_objects;
//
//import concurrency.design.future.Future;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author zhuanghuang
// * @date 2018/10/10
// */
//
//
///**
// * OrderServiceProxy是子类，作用是把OrderService的每一个方法封装成MethodMessage，然后提交给ActiveMessage队列
// * 可理解为执行线程需要一个future返回，调用线程也需要一个future返回
// */
//public class OrderServiceProxy implements OrderService {
//
//    private final OrderService orderService;
//    private final ActiveMessageQueue activeMessageQueue;
//
//    public OrderServiceProxy(OrderService orderService, ActiveMessageQueue activeMessageQueue) {
//        this.orderService = orderService;
//        this.activeMessageQueue = activeMessageQueue;
//    }
//
//    /**
//     * 对有返回值的方法返回必须是future类型
//     */
//    @Override
//    public Future<String> findOrderDetails(long orderId) {
//
//        //定义一个ActiveFuture，并且可支持立即返回
//        final ActiveFuture<String> activeFuture = new ActiveFuture<>();
//        //收集方法入参以及返回的ActiveFuture封装成MethodMessage
//        Map<String, Object> params = new HashMap<>();
//        params.put("orderId", orderId);
//        params.put("activeFuture", activeFuture);
//        MethodMessage methodMessage = new FindOrderDetailsMessage(params, orderService);
//        //传递给传送带，让传送上的woker线程执行任务后，future对象通过执行线程中finish方法得到result传递
//        activeMessageQueue.offer(methodMessage);
//        //返回给主程序
//        return activeFuture;
//    }
//
//    //无返回值无需future返回
//    @Override
//    public void order(String account, long orderId) {
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("orderId", orderId);
//        params.put("account", account);
//        MethodMessage methodMessage = new OrderMessage(params, orderService);
//        //传递给传送带，让传送上的woker线程执行任务后，future对象通过执行线程中finish方法得到result传递
//        activeMessageQueue.offer(methodMessage);
//    }
//}
