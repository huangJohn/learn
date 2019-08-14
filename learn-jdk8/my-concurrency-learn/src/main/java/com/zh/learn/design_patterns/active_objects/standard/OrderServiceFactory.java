package com.zh.learn.design_patterns.active_objects.standard;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-14
 */
public final class OrderServiceFactory {

    private final static ActiveMessageQueue ACTIVE_MESSAGE_QUEUE = new ActiveMessageQueue();

    private OrderServiceFactory() {
    }

    public static OrderService toActiveObject(OrderService orderService) {
        return new OrderServiceProxy((orderService), ACTIVE_MESSAGE_QUEUE);
    }

    public static void main(String[] args) throws InterruptedException {

        OrderService orderService = OrderServiceFactory.toActiveObject(new OrderServiceImpl());
        orderService.order("zh", 123L);
        System.out.println("return immediately");

        Thread.currentThread().join();
    }
}
