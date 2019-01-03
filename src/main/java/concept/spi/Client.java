package concept.spi;

import concept.spi.exception.ObjectSerializerException;
import concept.spi.impl.SerializerService;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/3
 */
public class Client {

    public static void main(String[] args) throws ObjectSerializerException {

        SerializerService serializerService = new SerializerService();
        ObjectSerializer serializer = serializerService.getObjectSerializer();
        System.out.println(serializer.getSchemeName());

        byte[] arrays = serializer.serialize(Arrays.asList("1", "2", "3"));
        ArrayList list = serializer.deSerialize(arrays, ArrayList.class);
        System.out.println(list);

    }
}
