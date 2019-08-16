package com.zh.learn.design_patterns.active_objects.standard;

import com.zh.learn.design_patterns.active_objects.generic.ActiveMethod;
import com.zh.learn.design_patterns.future.Future;
import com.zh.learn.design_patterns.future.FutureService;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-14
 */

public class OrderServiceImpl implements OrderService {

    @ActiveMethod
    @Override
    public Future<String> findOrderDetails(long orderId) {

        return FutureService.<Long, String>newService().submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "the order detail information";
        }, orderId, null);
    }

    @ActiveMethod
    @Override
    public void order(String account, long orderId) {

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("process the order for account = " + account + " , order id = " + orderId);
    }
}
