package com.zh.algs.cache.LRU;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/19
 */
public class LruCacheFactory extends AbstractCacheFactory{

    @Override
    public Cache createCache(String key, int max) {

        if (key.equals("inheritance")) {
            return new LruCache1(max);
        } else if (key.equals("linkedlist")) {
            return new LruCache2(max);
        } else {
            return null;
        }
    }
}
