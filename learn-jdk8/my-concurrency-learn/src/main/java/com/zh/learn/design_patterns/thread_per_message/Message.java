package com.zh.learn.design_patterns.thread_per_message;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-02
 */
public class Message {

    private final String vlaue;

    public Message(String vlaue) {
        this.vlaue = vlaue;
    }

    public String getVlaue() {
        return vlaue;
    }
}
