package com.zh.learn.design_patterns.future;


/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 * <p>
 * 桥接Future和FutureTask
 */
public interface FutureService<IN, OUT> {

    //提交不需要返回值的任务，Future.get()=null
    Future<?> submit(Runnable runnable);

    //提交需要返回值的任务，Task接口替代Runnable接口
    Future<OUT> submit(Task<IN, OUT> task, IN input);

    Future<OUT> submit(Task<IN, OUT> task, IN input, Callback<OUT> callback);

    static <IN, OUT> FutureService<IN, OUT> newService() {
        return new FutureServiceImpl<>();
    }

}
