package com.zh.algs.cache.LRU;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 * delegation方式实现更加优雅一些，但是由于没有实现Map接口，所以线程同步就需要自己搞定了
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-12
 */
public class LRUCacheWrapper<K, V> {

    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    private LinkedHashMap<K, V> map;

    public LRUCacheWrapper(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        //根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容
        //accessOrder=true，开启按照访问顺序排序
        int capacity = (int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTOR) + 1;
        map = new LinkedHashMap<K, V>(capacity, DEFAULT_LOAD_FACTOR, true) {
            //重写删除最老方法
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public void put(K key, V val) {
        map.put(key, val);
    }

    public V get(K key) {
        return map.get(key);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public Set<Map.Entry<K, V>> getAll() {
        return map.entrySet();
    }

    public int size() {
        return map.size();
    }

    public void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
