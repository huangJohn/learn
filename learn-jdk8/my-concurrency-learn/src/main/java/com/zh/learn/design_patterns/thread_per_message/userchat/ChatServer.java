package com.zh.learn.design_patterns.thread_per_message.userchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-10
 */
public class ChatServer {

    //server port
    private final int port;

    private final static Executor EXECUTOR = Executors.newFixedThreadPool(10);

    //server socket
    private ServerSocket serverSocket;

    public ChatServer(int port) {
        this.port = port;
    }

    public ChatServer() {
        this(13312);
    }

    public void startServer() throws IOException {

        this.serverSocket = new ServerSocket(this.port);
        this.serverSocket.setReuseAddress(true);
        System.out.println(" Chat Server is started and listened at prot: " + this.port);
        this.listen();
    }

    private void listen() throws IOException {
        for (; ; ) {
            Socket client = serverSocket.accept();
            EXECUTOR.execute(new ClientHandler(client));

        }
    }
}
