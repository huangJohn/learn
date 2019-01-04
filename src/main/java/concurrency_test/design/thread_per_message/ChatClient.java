package concurrency_test.design.thread_per_message;

import java.io.IOException;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */

public class ChatClient {

    public static void main(String[] args) throws IOException {

        new ChatServer().startServer();
    }
}
