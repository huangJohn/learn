package com.zh.algs.cache.LRU;

import java.util.Map;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/19
 */
public class LruCache2<K, V> implements Cache<K,V> {


    private final LRUCacheByLinkedListAndHashMap<K, V> store;

    public LruCache2(int max) {
        store = new LRUCacheByLinkedListAndHashMap<>(max);
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
