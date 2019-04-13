package com.zh.learn.basic.classloader;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-09
 */
public class Test2 {

    public static void main(String[] args) {

        Simple[] simples = new Simple[10];
        System.out.println(simples.length);//虽然new，事实上并没有类的初始化，本质是在堆内存开辟了一段连续的地址空间4byte*10

        System.out.println(GlobalConstants.MAX);

        System.out.println(GlobalConstants.RANDOM);
    }

}
