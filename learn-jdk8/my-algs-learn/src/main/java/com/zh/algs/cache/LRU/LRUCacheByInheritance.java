package com.zh.algs.cache.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 * LRU是Least Recently Used 的缩写，翻译过来就是“最近最少使用”，LRU缓存就是使用这种原理实现，
 * 简单的说就是缓存一定量的数据，当超过设定的阈值时就把一些过期的数据删除掉，
 * 比如我们缓存10000条数据，当数据小于10000时可以随意添加，
 * 当超过10000时就需要把新的数据添加进来，同时要把过期数据删除，以确保我们最大缓存10000条，
 * 那怎么确定删除哪条过期数据呢，采用LRU算法实现的话就是将最老的数据删掉
 * <p>
 * Java里面实现LRU缓存通常有两种选择，一种是使用LinkedHashMap，一种是自己设计数据结构，使用链表+HashMap
 * LinkedHashMap自身已经实现了顺序存储，默认情况下是按照元素的添加顺序存储，
 * 也可以启用按照访问顺序存储，即最近读取的数据放在最前面，最早读取的数据放在最后面，
 * 然后它还有一个判断是否删除最老数据的方法，默认是返回false，即不删除数据，
 * 我们使用LinkedHashMap实现LRU缓存的方法就是对LinkedHashMap实现简单的扩展，
 * 扩展方式有两种，一种是inheritance，一种是delegation，具体使用什么方式看个人喜好
 * <p>
 * LinkedHashMap的一个构造函数，当参数accessOrder为true时，即会开启按照访问顺序排序，最近访问的放在最前，最早访问的放在后面
 * public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
 *      super(initialCapacity, loadFactor);
 *      this.accessOrder = accessOrder;
 * }
 * <p>
 * LinkedHashMap自带的判断是否删除最老的元素方法，默认返回false，即不删除老数据
 * 我们要做的就是重写这个方法，当满足一定条件时删除老数据
 * protected boolean removeEldestEntry(Map.Node<K,V> eldest) {
 *      return false;
 * }
 * <p>
 * 采用继承方式实现比较简单，而且实现了Map接口，在多线程环境使用时可以使用 Collections.synchronizedMap()方法实现线程安全操作
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-12
 */
public class LRUCacheByInheritance<K, V> extends LinkedHashMap<K, V> {

    private final int MAX_CACHE_SIZE;//缓存最大容量

    public LRUCacheByInheritance(int cacheSize) {
        //当参数accessOrder为true时，即会开启按照访问顺序排序，最近访问的放在最前，最早访问的放在后面
        //根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    //LinkedHashMap自带的判断是否删除最老的元素方法，默认返回false，即不删除老数据
    //重写这个方法，当满足一定条件时删除老数据，容量大于上限时删除最老元素
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_CACHE_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
