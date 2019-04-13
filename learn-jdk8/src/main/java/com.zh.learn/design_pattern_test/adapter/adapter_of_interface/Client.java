package com.zh.learn.design_pattern_test.adapter.adapter_of_interface;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class Client {
    private static Port chatPort = new Chat();
    private static Port serverPort = new Server();

    public static void main(String[] args) {
        // 聊天服务
        chatPort.ftp();
        chatPort.net();

        // 服务器
        serverPort.mysql();
        serverPort.ssh();
        serverPort.tomcat();
        serverPort.net();
    }
}
