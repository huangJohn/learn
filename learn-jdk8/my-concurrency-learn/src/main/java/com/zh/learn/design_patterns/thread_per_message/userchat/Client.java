package com.zh.learn.design_patterns.thread_per_message.userchat;

import java.io.IOException;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-10
 */
public class Client {

    public static void main(String[] args) throws IOException {

        new ChatServer().startServer();
    }

}
