package com.zh.learn.concurrency_test.design.two_phase_termination;

import java.io.*;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.net.Socket;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */


/**
 * Phantom Reference 特点
 * 必须和ReferenceQueue一同使用
 * get方法返回始终是null
 * 垃圾回收器决定回收Phantom Reference对象的时候会将其插入关联的ReferenceQueue中
 * 使用Phantom Reference清理动作要比Object的finalize方法灵活
 */

public class ClientHanderWithTwoPhaseTermination2 implements Runnable {
    //client socket
    private final Socket socket;

    //client identity
    private final String clientIndentity;

    public ClientHanderWithTwoPhaseTermination2(final Socket socket) {
        this.socket = socket;
        this.clientIndentity = this.socket.getInetAddress().getHostAddress() + ":" + socket.getPort();
    }

    @Override
    public void run() {

        try {
            this.chat();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //task over and execute release work
            //
            this.release();
        }
    }

    private void release() {

        try {
            if (this.socket != null) {
                socket.close();
            }
        } catch (Throwable throwable) {
            if (socket != null) {
                //将socket实例加入Tracker中
                SocketCleaningTracker.track(socket);
            }
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

class SocketCleaningTracker {

    //定义ReferenceQueue
    private static final ReferenceQueue<Object> QUEUE = new ReferenceQueue<>();

    static {
        //启动cleaning线程
        new Cleaner().start();
    }

    public static void track(Socket socket) {
        new Tracker(socket, QUEUE);
    }

    private static class Cleaner extends Thread {

        private Cleaner() {
            super("SocketCleanerTracker");
            setDaemon(true);
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    Tracker tracker = (Tracker) QUEUE.remove();
                    tracker.close();
                } catch (InterruptedException e) {

                }
            }
        }
    }

    private static class Tracker extends PhantomReference<Object> {

        private final Socket socket;

        private Tracker(Socket socket, ReferenceQueue<? super Object> queue) {

            super(socket, queue);
            this.socket = socket;
        }

        public void close() {

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


