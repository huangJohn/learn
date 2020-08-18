package com.zh.algs.cache.LRU;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/19
 */
public interface CacheFactory<K, V> {

    Cache<K, V> getCache(String key, int max);
}
