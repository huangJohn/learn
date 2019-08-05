package com.zh.learn.design_patterns.thread_per_message;

import java.util.stream.IntStream;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-02
 */
public class PerThreadClient {

    public static void main(String[] args) {

        MessageHandler messageHandler = new MessageHandler();

        IntStream.rangeClosed(0, 10).forEach(i -> {
            messageHandler.request(new Message("" + i));
        });

        messageHandler.shutDown();

    }

}
