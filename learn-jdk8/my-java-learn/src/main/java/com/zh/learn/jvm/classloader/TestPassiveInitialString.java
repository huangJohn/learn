package com.zh.learn.jvm.classloader;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/28
 */
public class TestPassiveInitialString {

    static class ConstClass {
        static {
            System.out.println("const class inited.");
        }

        public static final String HELLO = "hello";
    }


    public static void main(String[] args) {

        //无const class加载，字符常量已经在编译期存储到了常量池
        System.out.println(ConstClass.HELLO);

    }

}
