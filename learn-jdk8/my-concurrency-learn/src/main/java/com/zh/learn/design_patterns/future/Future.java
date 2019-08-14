package com.zh.learn.design_patterns.future;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 * <p>
 * 未来的一个凭据
 */
public interface Future<T> {

    //返回计算后的结果，调用线程进入阻塞
    T get() throws InterruptedException;

    //判断任务是否已经被执行
    boolean done();
}
