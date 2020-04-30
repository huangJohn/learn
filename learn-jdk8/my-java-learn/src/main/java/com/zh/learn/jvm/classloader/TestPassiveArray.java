package com.zh.learn.jvm.classloader;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/28
 */
public class TestPassiveArray {

    public static void main(String[] args) {

        //未看见super类输出
        //super class已经loaded
        TestPassiveInitialClass.SuperClass[] superClasses = new TestPassiveInitialClass.SuperClass[10];


    }

}
