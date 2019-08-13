package com.zh.learn.design_patterns.thread_per_message.userchat;

import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.net.Socket;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-13
 */
public class SocketCleaningTracker {

    private static final ReferenceQueue<Object> QUEUE = new ReferenceQueue<>();

    static {
        new Cleaner().start();
    }

    public static void tracker(Socket socket) {
        new Tracker(socket, QUEUE);
    }

    //后台清理线程，守护，jvm退出可终止
    private static class Cleaner extends Thread {

        public Cleaner() {
            super("SocketCleaningTracker");
            setDaemon(true);
        }

        @Override
        public void run() {
            //当一个Tracker被垃圾回收时，主动调一次关闭，增加释放资源概率
            for (; ; ) {
                try {
                    Tracker tracker = (Tracker) QUEUE.remove();
                    tracker.close();
                } catch (InterruptedException e) {

                }
            }
        }
    }

    //PhantomReference子类
    private static class Tracker extends PhantomReference<Object> {

        public Tracker(Socket socket, ReferenceQueue<? super Object> queue) {
            super(socket, queue);
            this.socket = socket;
        }

        private final Socket socket;

        public void close() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
