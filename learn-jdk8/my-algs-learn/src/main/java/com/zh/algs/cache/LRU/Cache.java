package com.zh.algs.cache.LRU;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/19
 */
public interface Cache<K, V> {

    V get(K k);

    void put(K k, V v);
}
