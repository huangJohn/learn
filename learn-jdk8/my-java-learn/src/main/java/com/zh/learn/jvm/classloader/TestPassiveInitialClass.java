package com.zh.learn.jvm.classloader;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/28
 */
public class TestPassiveInitialClass {

    static class SuperClass {

        static {
            System.out.println("super class inited.");
        }

        public static int value = 30;
    }

    static class SubClass extends SuperClass {

        static {
            System.out.println("sub class inited.");
        }
    }

    public static void main(String[] args) {

        //未看见子类输出
        //SubClass loaded
        System.out.println(SubClass.value);

    }


}
