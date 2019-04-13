package com.zh.learn.basic.reference;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */

@FunctionalInterface
public interface CacheLoader<K, V> {

    //定义加载数据的方法
    V load(K k);

}
