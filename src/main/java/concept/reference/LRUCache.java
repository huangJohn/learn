package concept.reference;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */

public class LRUCache<K, V> {

    //用于记录key值的顺序
    private final LinkedList<K> keyList = new LinkedList<>();

    //用于存放数据
    private final Map<K, V> cahce = new HashMap<>();

    //cache最大容量
    private final int capacity;

    //cacheLoader接口提供一种加载数据的方式
    private final CacheLoader<K, V> cacheLoader;

    public LRUCache(int capacity, CacheLoader<K, V> cacheLoader) {

        this.capacity = capacity;
        this.cacheLoader = cacheLoader;
    }

    public void put(K key, V val) {

        //当元素数量超过容量时，删除最老的数据
        if (keyList.size() >= capacity) {

            //最老的数据
            K eldestKey = keyList.removeFirst();
            cahce.remove(eldestKey);
        }

        //如果数据已经存在，则从key队列中删除
        if (keyList.contains(key)) {
            keyList.remove(key);
        }
        //将可以放至最末尾
        keyList.addLast(key);
        cahce.put(key, val);
    }

    public V get(K key) {

        V val;
        //先将key从队列中删除
        boolean success = keyList.remove(key);
        //如果失败则说明该数据不存在
        if (!success) {
            //通过cacheLoader对数据进行加载
            val = cacheLoader.load(key);
            //调用put方法cache数据
            this.put(key, val);
        } else {
            //删除成功，则从cache中返回数据，并将key再次放到队列末尾
            val = cahce.get(key);
            keyList.addLast(key);
        }
        return val;
    }

    @Override
    public String toString() {
        return this.keyList.toString();
    }

    public static void main(String[] args) {

        LRUCache<String, Reference> cache = new LRUCache<>(4, key -> new Reference());
        cache.get("alex");
        cache.get("jack");
        cache.get("gavin");
        cache.get("leo");

        cache.get("david");
        System.out.println(cache.toString());
    }
}
