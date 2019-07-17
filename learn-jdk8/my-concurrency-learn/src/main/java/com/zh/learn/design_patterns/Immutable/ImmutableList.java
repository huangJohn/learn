package com.zh.learn.design_patterns.Immutable;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-17
 */
public final class ImmutableList {

    //final修饰
    private final List<String> list;

    public ImmutableList(List<String> list) {
        this.list = list;
    }

    public ImmutableList(ImmutableList immutableList, String s) {

        List<String> list = immutableList.getList();
        List<String> list_new = new ArrayList<>(list);
        synchronized (this) {
            list_new.add(s);
        }
        ImmutableList newImmutableList = new ImmutableList(list_new);
        this.list = newImmutableList.getList();
    }

    public List<String> getList() {
        return Collections.unmodifiableList(this.list);
    }

    public ImmutableList add(String s) {
        return new ImmutableList(this, s);
    }

    public static void main(String[] args) throws InterruptedException {

        List<String> list = Lists.newArrayList();
        list.add("s1");
        list.add("s2");

        ImmutableList immutableList = new ImmutableList(list);

        CountDownLatch latch = new CountDownLatch(3);
        IntStream.range(0, 3).forEach(i -> {
            new Thread(() -> {
                immutableList.getList().forEach(s -> {
                    System.out.println(Thread.currentThread().getName() + " => " + s);
                });
                latch.countDown();
            }).start();

        });

        latch.await();
        System.out.println("=======================");

        IntStream.range(0, 10).forEach(i -> {
            new Thread(() -> {
                ImmutableList add = immutableList.add("s3");
                add.getList().forEach(s -> {
                            System.out.println(Thread.currentThread().getName() + " => " + s);
                        }
                );
            }).start();
        });

    }
}
