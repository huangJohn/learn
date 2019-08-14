package com.zh.learn.design_patterns.active_objects.standard;

import com.zh.learn.design_patterns.future.Future;

import java.util.HashMap;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-14
 */
public class FindOrderDetailsMethodMessage extends MethodMessage {

    public FindOrderDetailsMethodMessage(HashMap<String, Object> params, OrderService orderService) {
        super(params, orderService);
    }

    @Override
    public void execute() {
        Future<String> realFuture = orderService.findOrderDetails((Long) params.get("oderId"));
        ActiveFuture<String> activeFuture = (ActiveFuture<String>) params.get("activeFuture");
        try {
            String result = realFuture.get();
            activeFuture.finish(result);
        } catch (InterruptedException e) {
            activeFuture.finish(null);
        }
    }
}
