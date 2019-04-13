package com.zh.learn.concurrency_test.design.thread_per_message;

import java.io.*;
import java.net.Socket;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */

public class ClientHander implements Runnable {

    //client socket
    private final Socket socket;

    //client identity
    private final String clientIndentity;

    public ClientHander(final Socket socket) {
        this.socket = socket;
        this.clientIndentity = this.socket.getInetAddress().getHostAddress() + ":" + socket.getPort();
    }

    @Override
    public void run() {

        try {
            this.chat();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void chat() throws IOException {

        BufferedReader bufferedReader = wrap2Reader(this.socket.getInputStream());
        PrintStream printStream = wrap2Print(this.socket.getOutputStream());
        String received = "";
        while (null != (received = bufferedReader.readLine())) {

            //display message on console
            System.out.printf("client: %s-message: %s\n", clientIndentity, received);
            if ("quit".equals(received)) {
                write2Client(printStream, "client will close");
                socket.close();
                break;
            }

            //send message to client
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
