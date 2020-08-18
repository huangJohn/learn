package com.zh.algs.cache.LRU;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-12
 */
public class LRUCacheClient {

    public static void main(String[] args) {

        System.out.println("===========start============");

        lruCache();
        lruCache2();
        lruCache3();

        CacheFactory cacheFactory = new LruCacheFactory();
        Cache cache = cacheFactory.getCache("linkedlist", 5);
        cache.put(1, "11");
        cache.put(2, "11");
        cache.put(3, "11");
        cache.put(4, "11");
        cache.put(5, "11");
        System.out.println(cache.toString());
        cache.put(6, "66");
        cache.put(7, "77");
        cache.get(2);
        cache.get(4);
        System.out.println(cache.toString());

    }

    public static void lruCache3() {
        System.out.println();
        System.out.println("===========================LRU 链表+hashmap实现===========================");
        LRUCacheByLinkedListAndHashMap<Integer, String> lru = new LRUCacheByLinkedListAndHashMap<>(5);
        lru.put(1, "11");
        lru.put(2, "11");
        lru.put(3, "11");
        lru.put(4, "11");
        lru.put(5, "11");
        System.out.println(lru.toString());
        lru.put(6, "66");
        lru.get(2);
        lru.put(7, "77");
        lru.get(4);
        System.out.println(lru.toString());
        System.out.println();
    }

    static <T> void lruCache() {
        System.out.println();
        System.out.println("===========================LRU LinkedHashMap(inheritance)实现===========================");
        LRUCacheByInheritance<Integer, String> lru = new LRUCacheByInheritance<>(5);
        lru.put(1, "11");
        lru.put(2, "11");
        lru.put(3, "11");
        lru.put(4, "11");
        lru.put(5, "11");
        System.out.println(lru.toString());
        lru.put(6, "66");
        lru.get(2);
        lru.put(7, "77");
        lru.get(4);
        System.out.println(lru.toString());
        System.out.println();
    }

    static void lruCache2() {
        System.out.println();
        System.out.println("===========================LRU LinkedHashMap(delegation)实现===========================");
        LRUCacheWrapper<Integer, String> lru = new LRUCacheWrapper<>(5);
        lru.put(1, "11");
        lru.put(2, "11");
        lru.put(3, "11");
        lru.put(4, "11");
        lru.put(5, "11");
        System.out.println(lru.toString());
        lru.put(6, "66");
        lru.get(2);
        lru.put(7, "77");
        lru.get(4);
        System.out.println(lru.toString());
        System.out.println();
    }


}
