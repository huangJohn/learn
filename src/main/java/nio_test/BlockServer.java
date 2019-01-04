package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockServer {

    public static void main(String[] args) throws IOException {

        //build serverSocket channel
        ServerSocketChannel server = ServerSocketChannel.open();

        //get file channel
        FileChannel channel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //bind link
        server.bind(new InetSocketAddress(6666));

        //get link from client (IO)
        SocketChannel client = server.accept();

        //get buffer
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //receive
        while (client.read(buf) != -1) {
            buf.flip();
            channel.write(buf);
            buf.clear();
        }

        //notify client
        buf.put("message: your image is success.".getBytes());
        buf.flip();
        client.write(buf);
        buf.clear();


        channel.close();
        client.close();
        server.close();
    }
}
