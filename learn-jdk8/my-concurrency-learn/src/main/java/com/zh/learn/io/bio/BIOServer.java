package com.zh.learn.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/8
 */
public class BIOServer {


    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        int port = 8080;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("sever established. port=" + serverSocket.getLocalPort());

            while (true) {

                socket = serverSocket.accept();
                System.out.println("client established. port=" + socket.getPort());

                inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];

                while (inputStream.read(bytes) > 0) {

                    String msg = new String(bytes, 0, bytes.length);
                    System.out.println("receive msg=" + msg);

                    outputStream = socket.getOutputStream();
                    outputStream.write("ok. server received.\n".getBytes());
                    outputStream.flush();
                }


            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
