package com.zh.learn.nio_test;

import java.nio.ByteBuffer;

public class BufferTest {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 初始时4个核心变量的值
        System.out.println("初始时-->limit--->" + buffer.limit());
        System.out.println("初始时-->position--->" + buffer.position());
        System.out.println("初始时-->capacity--->" + buffer.capacity());
        System.out.println("初始时-->mark--->" + buffer.mark());

        System.out.println("--------------------------------------");

        // 添加一些数据到缓冲区中
        String s = "zhuanghuang";
        buffer.put(s.getBytes());

        // 4个核心变量的值
        System.out.println("put完之后-->limit--->" + buffer.limit());
        System.out.println("put完之后-->position--->" + buffer.position());
        System.out.println("put完之后-->capacity--->" + buffer.capacity());
        System.out.println("put完之后-->mark--->" + buffer.mark());

        buffer.flip();
        System.out.println("--------------------------------------");
        System.out.println("flip完之后-->limit--->" + buffer.limit());
        System.out.println("flip完之后-->position--->" + buffer.position());
        System.out.println("flip完之后-->capacity--->" + buffer.capacity());
        System.out.println("flip完之后-->mark--->" + buffer.mark());

        System.out.println("-------------------------------------");
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));

        System.out.println("-------------------------------------");
        System.out.println("get完之后-->limit--->" + buffer.limit());
        System.out.println("get完之后-->position--->" + buffer.position());
        System.out.println("get完之后-->capacity--->" + buffer.capacity());
        System.out.println("get完之后-->mark--->" + buffer.mark());

        buffer.clear();
        System.out.println("-------------------------------------");
        System.out.println("clear完之后-->limit--->" + buffer.limit());
        System.out.println("clear完之后-->position--->" + buffer.position());
        System.out.println("clear完之后-->capacity--->" + buffer.capacity());
        System.out.println("clear完之后-->mark--->" + buffer.mark());


    }
}
