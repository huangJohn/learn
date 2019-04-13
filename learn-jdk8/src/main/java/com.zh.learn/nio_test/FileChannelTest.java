package com.zh.learn.nio_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) {


        /*通过操作FileChannel和Buffer进行文件IO*/
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\zhuanghuang\\Downloads\\1.jpg");
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\zhuanghuang\\Downloads\\login-flow22.jpg");
            FileChannel channel = fileInputStream.getChannel();
            FileChannel channel2 = fileOutputStream.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (channel.read(buf) != -1) {
                buf.flip();
                channel2.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
