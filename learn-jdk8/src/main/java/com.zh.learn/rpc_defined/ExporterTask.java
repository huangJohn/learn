package com.zh.learn.rpc_defined;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class ExporterTask implements Runnable {

    Socket client = new Socket();

    public ExporterTask(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;

        try {

            /*读流*/
            inputStream = new ObjectInputStream(client.getInputStream());

            /*获取调用接口名*/
            String interfaceName = inputStream.readUTF();
            /*获取接口实例类*/
            Class<?> service = Class.forName(interfaceName);

            /*获取调用方法名*/
            String methodName = inputStream.readUTF();
            /*获取调用参数类型*/
            Class<?>[] paramTypes = (Class<?>[]) inputStream.readObject();
            /*调用参数*/
            Object[] args = (Object[]) inputStream.readObject();
            /*获取调用方法*/
            Method method = service.getMethod(methodName, paramTypes);
            /*调用*/
            Object result = method.invoke(service.newInstance(), args);
            /*输出流*/
            outputStream = new ObjectOutputStream(client.getOutputStream());
            outputStream.writeObject(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
