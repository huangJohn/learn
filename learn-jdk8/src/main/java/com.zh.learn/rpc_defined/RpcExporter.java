package com.zh.learn.rpc_defined;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class RpcExporter {

    private static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String hostName, int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(hostName, port));

        try {
            while (true) {
                executor.execute(new ExporterTask(serverSocket.accept()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}
