package com.zh.learn.concurrency_test.design.thread_per_message;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * thread-per-message 设计模式旨在为每一个消息的处理开辟一个线程使得消息能够以并发的方式进行处理，从而整体提高系统的吞吐量
 * 应用的典型场景在：
 * 基于事件的编程模型中，系统初始化事件发生时，进行若干资源的后台加载，由于系统初始化任务数量并不多，所以可考虑使用该设计模式；
 * 也可以在系统关闭时，进行资源回收、销毁事件使用，结合线程池使用，减小线程创建和销毁的开销
 */

public class ChatServer {

    //server port
    private final int port;

    //thread pool
    private ExecutorService executorService;

    //server socket
    private ServerSocket serverSocket;

    public ChatServer(int port) {
        this.port = port;
    }

    public ChatServer() {
        this(13312);
    }

    public void startServer() throws IOException {

        this.executorService = Executors.newFixedThreadPool(1000);
        this.serverSocket = new ServerSocket(this.port);
        this.serverSocket.setReuseAddress(true);
        System.out.println("Chat Server is started and is listened at port: " + this.port);
        this.listen();
    }

    private void listen() throws IOException {

        for (; ; ) {
            Socket client = serverSocket.accept();
            this.executorService.execute(new ClientHander(client));
        }
    }


}
