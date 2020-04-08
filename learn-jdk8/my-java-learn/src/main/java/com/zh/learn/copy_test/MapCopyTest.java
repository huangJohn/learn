package com.zh.learn.copy_test;

import com.google.common.collect.Maps;

import java.util.Date;
import java.util.HashMap;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/1/6
 */
public class MapCopyTest {

    public static void main(String[] args) {


        HashMap<Integer, Object> hashMap = Maps.newHashMap();

        hashMap.put(1, 1);
        hashMap.put(2, 1);
        hashMap.put(3, 1);

        User user = new User();
        user.setId(123);
        user.setUsername("123");
        user.setSex("123");
        user.setBirthday(new Date());
        user.setAddress("123");
        Person person = new Person();
        person.setId(123);
        person.setUsername("123");
        person.setAge(123);
        person.setMobilePhone("123");
        user.setPerson(person);

        hashMap.put(4, user);


        System.out.println(hashMap);

        HashMap<Integer, Object> clone = (HashMap<Integer, Object>) hashMap.clone();

        Person person2 = new Person();
        person2.setId(123);
        person2.setUsername("123person2");
        person2.setAge(123);
        person2.setMobilePhone("123person2");
        user.setPerson(person2);


        ((User) clone.get(4)).setPerson(person2);

        System.out.println(clone);
        System.out.println(hashMap);
    }

}
