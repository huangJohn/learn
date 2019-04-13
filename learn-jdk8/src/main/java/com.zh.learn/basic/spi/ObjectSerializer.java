package com.zh.learn.basic.spi;

import com.zh.learn.basic.spi.exception.ObjectSerializerException;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/3
 */

public interface ObjectSerializer {

    byte[] serialize(Object obj) throws ObjectSerializerException;

    <T> T deSerialize(byte[] param, Class<T> clazz) throws ObjectSerializerException;

    String getSchemeName();
}

