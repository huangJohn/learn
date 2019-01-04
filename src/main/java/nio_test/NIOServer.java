package nio_test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * @author Zhuang Huang
 * @date 2018/5/20
 */
public class NIOServer {


    public static void main(String[] args) throws IOException {

        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress(6666));
        Selector selector = Selector.open();
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024 * 1000);
                    FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
                    while (client.read(buffer) > 0) {
                        buffer.flip();
                        outChannel.write(buffer);
                        buffer.clear();
                    }
                    outChannel.close();
                    ByteBuffer res = ByteBuffer.allocate(1024);
                    res.put("has received.".getBytes());
                    res.flip();
                    client.write(res);
                }
                iterator.remove();
            }
        }

    }
}
