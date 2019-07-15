package com.zh.learn.design_patterns.future;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 *
 * 未来的一个凭据
 */
public interface Future<T> {

    T get() throws InterruptedException;

}
