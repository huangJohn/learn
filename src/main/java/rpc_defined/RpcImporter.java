package rpc_defined;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class RpcImporter<S> {

    @SuppressWarnings("unchecked")
    public S importer(final Class<?> serviceClass, final InetSocketAddress address) {
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class<?>[]{
                        serviceClass.getInterfaces()[0]}, new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = null;
                        ObjectOutputStream output = null;
                        ObjectInputStream input = null;
                        Object obj = null;
                        try {
                            socket = new Socket();
                            socket.connect(address);
                            output = new ObjectOutputStream(socket.getOutputStream());
                            output.writeUTF(serviceClass.getName());
                            output.writeUTF(method.getName());
                            output.writeObject(method.getParameterTypes());
                            output.writeObject(args);
                            input = new ObjectInputStream(socket.getInputStream());
                            obj = input.readObject();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (null != output) {
                                output.close();
                            }
                            if (null != input) {
                                input.close();
                            }
                            if (socket != null) {
                                socket.close();
                            }
                        }
                        return obj;
                    }
                }
        );
    }


}
