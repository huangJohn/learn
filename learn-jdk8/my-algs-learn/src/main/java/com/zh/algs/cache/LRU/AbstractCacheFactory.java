package com.zh.algs.cache.LRU;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/19
 */
public abstract class AbstractCacheFactory<K, V> implements CacheFactory<K, V> {

    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap();

    @Override
    public Cache getCache(String key, int max) {

        Cache cache = caches.get(key);
        if (cache == null) {
            caches.put(key, createCache(key, max));
            cache = caches.get(key);
        }
        return cache;
    }

    public abstract Cache createCache(String key, int max);
}
