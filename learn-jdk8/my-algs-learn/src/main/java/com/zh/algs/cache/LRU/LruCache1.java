package com.zh.algs.cache.LRU;

import java.util.Map;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/19
 */
public class LruCache1<K, V> implements Cache<K, V> {

    private Map<K, V> store;

    public LruCache1(int max) {
        store = new LRUCacheByInheritance<>(max);
    }

    @Override
    public V get(K k) {
        return store.get(k);
    }

    @Override
    public void put(K k, V v) {
        store.put(k, v);
    }

    @Override
    public String toString() {
        return store.toString();
    }
}
