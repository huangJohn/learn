package com.zh.learn.aop.aop.tutorial.example;

import java.io.Serializable;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/9/15
 */
public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = -4674367885474277311L;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
