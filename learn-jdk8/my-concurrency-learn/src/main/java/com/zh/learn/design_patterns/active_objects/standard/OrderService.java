package com.zh.learn.design_patterns.active_objects.standard;


import com.zh.learn.design_patterns.future.Future;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-14
 */
public interface OrderService {

    Future<String> findOrderDetails(long orderId);

    void order(String account, long orderId);

}
