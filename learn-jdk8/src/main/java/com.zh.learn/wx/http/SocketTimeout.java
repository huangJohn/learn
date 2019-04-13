package com.zh.learn.wx.http;

/**
 * @author kkshu
 * <p>
 * 超时时间设置,支持特定几种,单位s
 */
public enum SocketTimeout {

    timeout_2_s(2), timeout_5_s(5);

    private SocketTimeout(int value) {
        this.value = value;
    }

    int value;

    public int value() {
        return this.value;
    }
}
