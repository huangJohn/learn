package concurrency_test.design.two_phase_termination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */

/**
 * two-phase-termination 两阶段设计模式
 * 线程处在执行状态时，当外部希望结束这个线程时，发出线程结束请求，接下来线程并不会立即结束，而是会执行响应的资源释放动作直到真正结束，
 * 在终止结束时，线程虽然还在运行，但是进行的是终止处理工作，因此终止处理又称为线程结束的第二阶段，受理终止请求则被称为线程结束的第一阶段。
 * 在第二阶段时，通常加入finally子句，执行资源的主动关闭，对于进程两阶段场景下，可以用一个或多个hook线程注入的方式到达目的
 * 两阶段需要注意以下;
 * 第二阶段的终止保证安全性
 * 百分之百确保线程结束
 * 对资源的释放动作花销的时间控制在一个可控的时间范围
 */

public class ClientHanderWithTwoPhaseTermination implements Runnable {

    //client socket
    private final Socket socket;

    //client identity
    private final String clientIndentity;

    public ClientHanderWithTwoPhaseTermination(final Socket socket) {
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
        } catch (IOException e) {

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
