package com.zh.learn.basic.spi.impl;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.zh.learn.basic.spi.ObjectSerializer;
import com.zh.learn.basic.spi.exception.ObjectSerializerException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/3
 */
public class KryoSerializer implements ObjectSerializer {

    @Override
    public byte[] serialize(Object obj) throws ObjectSerializerException {
        byte[] bytes;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            //获取kryo对象
            Kryo kryo = new Kryo();
            Output output = new Output(outputStream);
            kryo.writeObject(output, obj);
            bytes = output.toBytes();
            output.flush();
        } catch (Exception ex) {
            throw new ObjectSerializerException("kryo serialize error" + ex.getMessage());
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {

            }
        }
        return bytes;
    }

    @Override
    public <T> T deSerialize(byte[] param, Class<T> clazz) throws ObjectSerializerException {
        T object;
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(param)) {
            Kryo kryo = new Kryo();
            Input input = new Input(inputStream);
            object = kryo.readObject(input, clazz);
            input.close();
        } catch (Exception e) {
            throw new ObjectSerializerException("kryo deSerialize error" + e.getMessage());
        }
        return object;
    }

    @Override
    public String getSchemeName() {
        return "kryoSerializer";
    }
}
