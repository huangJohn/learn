package com.zh.learn.exception;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-17
 */
public class MyRpcException extends RuntimeException {

    private static final long serialVersionUID = 1937690896875934228L;

    public MyRpcException() {
        super();
    }

    public MyRpcException(String msg) {
        super(msg);
    }
}
