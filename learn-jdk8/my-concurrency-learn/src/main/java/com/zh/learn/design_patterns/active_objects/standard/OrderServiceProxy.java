package com.zh.learn.design_patterns.active_objects.standard;

import com.google.common.collect.Maps;
import com.zh.learn.design_patterns.future.Future;

import java.util.HashMap;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-14
 */
public class OrderServiceProxy implements OrderService {

    private final OrderService orderService;
    private final ActiveMessageQueue activeMessageQueue;

    public OrderServiceProxy(OrderService orderService, ActiveMessageQueue activeMessageQueue) {
        this.orderService = orderService;
        this.activeMessageQueue = activeMessageQueue;
    }

    @Override
    public Future<String> findOrderDetails(long orderId) {
        //activeFuture可支持立即返回
        final ActiveFuture<String> activeFuture = new ActiveFuture<>();
        //收集方法入参和activeFuture封装成message
        HashMap<String, Object> params = Maps.<String, Object>newHashMap();
        params.put("orderId", orderId);
        params.put("activeFuture", activeFuture);
        MethodMessage methodMessage = new FindOrderDetailsMethodMessage(params, orderService);
        activeMessageQueue.offer(methodMessage);
        return activeFuture;
    }

    @Override
    public void order(String account, long orderId) {
        HashMap<String, Object> params = Maps.<String, Object>newHashMap();
        params.put("account", account);
        params.put("orderId", orderId);
        MethodMessage methodMessage = new OrderMethodMessage(params, orderService);
        activeMessageQueue.offer(methodMessage);
    }
}
