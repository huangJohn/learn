package rpc_defined;

import java.net.InetSocketAddress;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class RpcTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 8888);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<>();
        EchoService service = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8888));
        String echo = service.echo("are you ok ?");
        System.out.println(echo);
        String echo1 = service.echo(null);
        System.out.println(echo1);
    }
}
