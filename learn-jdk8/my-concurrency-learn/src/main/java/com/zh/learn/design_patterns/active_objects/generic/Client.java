package com.zh.learn.design_patterns.active_objects.generic;

import com.zh.learn.design_patterns.active_objects.standard.OrderService;
import com.zh.learn.design_patterns.active_objects.standard.OrderServiceImpl;
import com.zh.learn.design_patterns.future.Future;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {


        OrderService active = ActiveServiceFactory.active(new OrderServiceImpl());
        Future<String> future = active.findOrderDetails(123L);
        System.out.println("i will be returned immediately");
        System.out.println(future.get());
    }

}
