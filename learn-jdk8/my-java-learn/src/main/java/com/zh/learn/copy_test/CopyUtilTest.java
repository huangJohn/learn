package com.zh.learn.copy_test;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/1/3
 */
public class CopyUtilTest {

    public static void main(String[] args) {


        User user = new User();
        user.setId(1);
        user.setUsername("zhuang");
        user.setSex("man");
        user.setBirthday(new Date());
        user.setAddress("beijing");

        Person person = new Person();
        person.setId(1);
        person.setUsername("p1");
        person.setAge(20);
        person.setMobilePhone("12312341234");

        user.setPerson(person);


        User target = new User();

        BeanUtils.copyProperties(user, target);

        System.out.println(target.getAddress().equals(user.getAddress()));
        System.out.println(target.getPerson() == user.getPerson());
        System.out.println("********************");
        System.out.println(target.toString());
        System.out.println(user.toString());
        System.out.println("********************");
        target.getPerson().setAge(22);
        System.out.println(target.toString());
        System.out.println(user.toString());
        System.out.println("********************");
        user.getPerson().setAge(23);
        System.out.println(target.toString());
        System.out.println(user.toString());
        System.out.println("********************");
        user.setAddress("cq");
        System.out.println(target.toString());
        System.out.println(user.toString());
        System.out.println("********************");


        User target2 = new User();
        try {
            org.apache.commons.beanutils.BeanUtils.copyProperties(target2, user);
            System.out.println(target2);
            System.out.println("********************");
            target2.getPerson().setAge(24);
            System.out.println(target2.toString());
            System.out.println(user.toString());
            System.out.println("********************");
            user.getPerson().setAge(25);
            System.out.println(target2.toString());
            System.out.println(user.toString());
            System.out.println("********************");
            user.setAddress("sh");
            System.out.println(target2.toString());
            System.out.println(user.toString());
            System.out.println("********************");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //2个工具都是浅拷贝

    }

}
