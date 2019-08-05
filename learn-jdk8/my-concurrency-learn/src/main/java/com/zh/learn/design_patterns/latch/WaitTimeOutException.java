package com.zh.learn.design_patterns.latch;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-05
 */
public class WaitTimeOutException extends Exception {

    public WaitTimeOutException(String message) {
        super(message);
    }
}
