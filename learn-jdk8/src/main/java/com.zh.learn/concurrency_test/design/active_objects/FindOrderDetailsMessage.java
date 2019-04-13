package com.zh.learn.concurrency_test.design.active_objects;

import com.zh.learn.concurrency_test.design.future.Future;

import java.util.Map;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class FindOrderDetailsMessage extends MethodMessage {


    public FindOrderDetailsMessage(Map<String, Object> params, OrderService orderService) {
        super(params, orderService);
    }

    @Override
    public void execute() {

        //获取参数并真正执行
        Future<String> future = orderService.findOrderDetails((long) params.get("orderId"));
        ActiveFuture<String> activeFuture = (ActiveFuture<String>) params.get("activeFuture");
        try {
            String result = future.get();//执行线程立即返回的结果，此方法会阻塞直到findOrderDetails方法执行结束
            activeFuture.finish(result);//调用线程立即返回的结果，将结果传递给ActiveFuture
        } catch (InterruptedException e) {
            activeFuture.finish(null);
        }
    }
}
