package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockClient {

    public static void main(String[] args) throws IOException {

        //build socket channel
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));

        //get channel
        FileChannel fileChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

        //get buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //read file and send to server
        while (fileChannel.read(buffer) != -1) {
            buffer.flip();//switch to read model
            socketChannel.write(buffer);//write
            buffer.clear();//switch to write model and let to read again
        }

        /*显式告诉服务器数据写完*/
        socketChannel.shutdownOutput();

        //response from server
        int len = 0;
        while ((len = socketChannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }

        fileChannel.close();
        socketChannel.close();
    }
}
