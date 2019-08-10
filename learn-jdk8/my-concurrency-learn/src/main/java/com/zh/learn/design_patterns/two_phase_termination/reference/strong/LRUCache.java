package com.zh.learn.design_patterns.two_phase_termination.reference.strong;

import com.zh.learn.design_patterns.two_phase_termination.reference.MyCacheLoader;

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
public class LRUCache<K, V> {

    //keyList对key顺序管理
    private final LinkedList<K> keyList = new LinkedList<>();

    //存放真正数据
    private final Map<K, V> cache = new HashMap<>();

    private final int capcity;

    //cacheLoader提供加载数据的一种方式
    private final MyCacheLoader<K, V> cacheLoader;


    public LRUCache(int capcity, MyCacheLoader<K, V> cacheLoader) {
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
        cache.put(key, val);
    }

    public V get(K key) {
        V value;
        boolean success = keyList.remove(key);
        //失败，表示不存在数据
        if (!success) {
            value = cacheLoader.load(key);
            put(key, value);
        } else {
            value = cache.get(key);
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
//
//        LRUCache<String, Reference> cache = new LRUCache<>(5, key -> {
//            return new Reference();
//        });
//
//        cache.get("a");
//        cache.get("b");
//        cache.get("c");
//        cache.get("d");
//        cache.get("e");
//
//        System.out.println(cache.toString());
//
//        cache.get("f");
//        System.out.println(cache.toString());

        LRUCache<Integer, Reference> cache = new LRUCache<>(200, k->{
            return new Reference();
        });

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            cache.get(i);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("the " + i + " reference is stored in cache");
        }
    }
}
