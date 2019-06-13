package com.zh.algs.cache.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 * FIFO是First Input First Output的缩写，也就是常说的先入先出，
 * 默认情况下LinkedHashMap就是按照存储顺序保存，我们只需重写下removeEldestEntry方法即可轻松实现一个FIFO缓存
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-12
 */
public class LRUCacheFIFO<K, V> extends LinkedHashMap<K, V> {

    private final int MAX_CACHE_SIZE;

    public LRUCacheFIFO(int cacheSize) {
        //accessOrder false, 按照存储顺序访问
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f);
        MAX_CACHE_SIZE = cacheSize;
    }

    //LinkedHashMap自带的判断是否删除最老的元素方法，默认返回false，即不删除老数据
    //要做的就是重写这个方法，当满足一定条件时删除老数据
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
