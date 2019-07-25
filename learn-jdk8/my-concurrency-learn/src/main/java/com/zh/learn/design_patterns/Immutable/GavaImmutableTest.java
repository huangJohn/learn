package com.zh.learn.design_patterns.Immutable;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-17
 */
public class GavaImmutableTest {

    public static void main(String[] args) {

        //jdk
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        List<Integer> list1 = Collections.unmodifiableList(list);

        //throw ex
//        list1.add(3);

        //原集合add后，不可变list1也变化，jdk unmodifiableList不是真正地实现不可变
        list.add(3);

        System.out.println("jdk");
        list1.forEach(System.out::println);

        //不可变本质上是不提供写入方法
        ImmutableList<Integer> integers = ImmutableList.copyOf(list);

        list.add(4);

        System.out.println("guava");
        integers.forEach(System.out::println);

    }

}
