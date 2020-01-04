package com.zh.learn.copy_test;

import lombok.Data;
import lombok.ToString;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/1/3
 */

@Data
@ToString
public class Person {

    private int id;

    private String username;

    private int age;

    private String mobilePhone;

    public Person() {
    }

    public Person(int id, String username, int age, String mobilePhone) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.mobilePhone = mobilePhone;
    }

}
