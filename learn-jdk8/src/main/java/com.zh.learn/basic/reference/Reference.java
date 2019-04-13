package com.zh.learn.basic.reference;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */

/**
 * Strong Reference 特点
 * 只要引用到ROOT根的路径可达，无论怎么样的GC都不会将其释放，而是宁可出现内存溢出
 * 一个对象被关键字new实例化出来的时候，该对象就是一种强引用
 *
 * SoftReference和WeakReference会不断被垃圾回收期回收，除非容器插入的速度过快，不会导致内存溢出
 * 两种引用被回收后，会存放至一个关联的ReferenceQueue中
 *
 *
 */

public class Reference {

    //1M
    private final byte[] data = new byte[2 << 19];

    @Override
    protected void finalize() {
        System.out.println("the reference will be GC");
    }
}
