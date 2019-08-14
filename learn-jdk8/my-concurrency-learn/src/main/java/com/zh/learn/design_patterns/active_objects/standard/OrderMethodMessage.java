package com.zh.learn.design_patterns.active_objects.standard;

import java.util.HashMap;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-14
 */
public class OrderMethodMessage extends MethodMessage {

    public OrderMethodMessage(HashMap<String, Object> params, OrderService orderService) {
        super(params, orderService);
    }

    @Override
    public void execute() {
        String account = (String) params.get("account");
        Long orderId = (Long) params.get("orderId");
        orderService.order(account, orderId);
    }
}
