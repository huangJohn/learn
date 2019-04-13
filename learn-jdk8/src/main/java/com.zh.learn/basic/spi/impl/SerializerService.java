package com.zh.learn.basic.spi.impl;

import com.zh.learn.basic.spi.ObjectSerializer;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/3
 */
@Service
public class SerializerService {

    public ObjectSerializer getObjectSerializer() {
        ServiceLoader<ObjectSerializer> serializers = ServiceLoader.load(ObjectSerializer.class);

//        Iterator<ObjectSerializer> iterator = serializers.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        final Optional<ObjectSerializer> serializer = StreamSupport.stream(serializers.spliterator(), false)
                .findFirst();

        return serializer.orElse(new JavaSerializer());
    }
}
