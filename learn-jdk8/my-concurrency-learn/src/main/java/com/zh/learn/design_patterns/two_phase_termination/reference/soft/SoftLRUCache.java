package com.zh.learn.design_patterns.two_phase_termination.reference.soft;

import com.zh.learn.design_patterns.two_phase_termination.reference.MyCacheLoader;
import com.zh.learn.design_patterns.two_phase_termination.reference.strong.LRUCache;
import com.zh.learn.design_patterns.two_phase_termination.reference.strong.Reference;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-10
 */
public class SoftLRUCache<K, V> {

    //keyList对key顺序管理
    private final LinkedList<K> keyList = new LinkedList<>();

    //存放真正数据
    //软应用封装，fgc前回收
    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    private final int capcity;

    //cacheLoader提供加载数据的一种方式
    private final MyCacheLoader<K, V> cacheLoader;


    public SoftLRUCache(int capcity, MyCacheLoader<K, V> cacheLoader) {
        this.capcity = capcity;
        this.cacheLoader = cacheLoader;
    }

    public void put(K key, V val) {

        if (keyList.size() >= capcity) {
            K eldestKey = keyList.removeFirst();
            cache.remove(eldestKey);
        }

        if (keyList.contains(key)) {
            keyList.remove(key);
        }

        keyList.addLast(key);
        cache.put(key, new SoftReference<>(val));
    }

    public V get(K key) {
        V value;
        boolean success = keyList.remove(key);
        //失败，表示不存在数据
        if (!success) {
            value = cacheLoader.load(key);
            put(key, value);
        } else {
            value = cache.get(key).get();
            keyList.addLast(key);
        }
        return value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LRUCache.class.getSimpleName() + "[", "]")
                .add("keyList=" + keyList)
                .toString();

    }

    public static void main(String[] args) throws InterruptedException {
        SoftLRUCache<Integer, Reference> cache = new SoftLRUCache<>(200, k -> {
            return new Reference();
        });

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            cache.get(i);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("the " + i + " reference is stored in cache");
        }
    }
}
