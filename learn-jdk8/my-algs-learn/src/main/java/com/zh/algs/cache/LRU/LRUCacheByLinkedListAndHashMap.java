package com.zh.algs.cache.LRU;

import java.util.HashMap;

/**
 * Description:
 * 双链表+hashmap实现，自己设计数据结构
 * 此实现为非线程安全，若在多线程环境下使用需要在相关方法上添加synchronized以实现线程安全操作
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-12
 */
public class LRUCacheByLinkedListAndHashMap<K, V> {

    private final int MAX_CACHE_SIZE;
    private Node first;
    private Node last;
    private HashMap<K, Node<K, V>> hashMap;


    public LRUCacheByLinkedListAndHashMap(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        hashMap = new HashMap<>();
    }

    public void put(K key, V val) {
        Node<K, V> node = getNode(key);
        if (node == null) {//缓存中不存在这个元素
            if (hashMap.size() >= MAX_CACHE_SIZE) {//超过容量了
                hashMap.remove(last.key);//删除最老
                removeLast();//处理last引用
            }
            node = new Node<>();//new
            node.key = key;//set key
        }
        node.val = val;//set val
        moveToFirst(node);
        hashMap.put(key, node);//set in map
    }

    public V get(K key) {
        Node<K, V> node = getNode(key);
        if (node == null) {
            return null;
        }
        moveToFirst(node);
        return node.val;
    }

    public void remove(K key) {
        Node<K, V> node = getNode(key);
        if (node != null) {
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (node == first) {
                first = node.next;
            }
            if (node == last) {
                last = node.pre;
            }
        }
        hashMap.remove(key);
    }

    private void moveToFirst(Node<K, V> node) {
        if (node == first) {
            return;
        }

        if (node.pre != null) {
            node.pre.next = node.next;//pre节点指向当前node后面的节点
        }

        if (node.next != null) {
            node.next.pre = node.pre;//双向，当前node后面的节点的pre指向当前node上一个节点
        }

        if (node == last) {
            last = last.pre;
        }

        if (first == null || last == null) {
            first = last = node;
            return;
        }

        //move to first
        node.next = first;
        first.pre = node;
        first = node;
        node.pre = null;
    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;//取前节点
            if (last == null) {//null
                first = null;
            } else {
                last.next = null;//置null
            }
        }
    }

    private Node<K, V> getNode(K key) {
        return hashMap.get(key);
    }

    class Node<K, V> {
        public Node pre;
        public Node next;
        public K key;
        public V val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = first;
        while (node != null) {
            sb.append(String.format("%s:%s ", node.key, node.val));
            node = node.next;
        }
        return sb.toString();
    }
}
