package com.zh.learn.design_patterns.thread_per_message.userchat;

import java.io.*;
import java.net.Socket;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-10
 */
public class ClientHandler implements Runnable {

    private final Socket client;

    private final String clientIdentify;

    public ClientHandler(final Socket client) {
        this.client = client;
        this.clientIdentify = client.getInetAddress().getHostAddress() + ":" + client.getPort();
    }

    @Override
    public void run() {

        try {
            this.chat();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //异常也要释放资源
        finally {
            this.release();
        }
    }

    private void release() {

        try {
            if (this.client != null) {
                client.close();
            }
        } catch (IOException e) {
            //socket关闭释放仍然可能不成功
            //二阶段利用PhantomReference特性再关闭一次，增加成功概率
            if (this.client != null) {
                SocketCleaningTracker.tracker(client);
            }
        }
    }

    private void chat() throws IOException {

        BufferedReader bufferedReader = wrap2Reader(this.client.getInputStream());
        PrintStream printStream = wrap2Print(this.client.getOutputStream());

        String received;

        while ((received = bufferedReader.readLine()) != null) {

            System.out.printf("client: %s - message: %s\n", clientIdentify, received);
            if (received.equals("quit")) {
                write2Client(printStream, "client will close");
                this.client.close();
                break;
            }

            write2Client(printStream, "Server: " + received);
        }
    }

    private void write2Client(PrintStream printStream, String msg) {
        printStream.println(msg);
        printStream.flush();
    }

    private PrintStream wrap2Print(OutputStream outputStream) {
        return new PrintStream(outputStream);
    }

    private BufferedReader wrap2Reader(InputStream inputStream) {

        return new BufferedReader(new InputStreamReader(inputStream));
    }
}
