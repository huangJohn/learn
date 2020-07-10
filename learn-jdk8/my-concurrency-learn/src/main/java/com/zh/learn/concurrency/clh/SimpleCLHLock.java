package com.zh.learn.concurrency.clh;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/6/17
 */
public class SimpleCLHLock implements SimpleLock {

    //所有线程公用的队列尾巴，用AtomicReference包装，每当线程入队后，把自己设置为tail
    private final AtomicReference<QNode> tail;

    //前驱节点，每个线程独有
    private final ThreadLocal<QNode> myPrev;

    //当前节点，线程自己，每个线程独有
    private final ThreadLocal<QNode> myNode;

    public SimpleCLHLock() {

        tail = new AtomicReference<>(new QNode());
        myNode = new ThreadLocal<QNode>() {
            @Override
            protected QNode initialValue() {
                return new QNode();
            }
        };
        myPrev = new ThreadLocal<QNode>() {
            @Override
            protected QNode initialValue() {
                return null;
            }
        };
    }

    @Override
    public void lock() {
        //获取当前线程节点
        QNode qNode = this.myNode.get();
        //设置自己true，表示需要获取锁
        qNode.locked = true;
        // 将自己放在队列的尾巴，并且返回tail以前的值。第一次进将获取构造函数中的那个new QNode
        QNode prev = this.tail.getAndSet(qNode);
        // 把旧的节点放入前驱节点。
        this.myPrev.set(prev);
        while (prev.locked) {

        }
        //前驱自选结束，释放，当前拿到锁
    }

    @Override
    public void unLock() {
        //把自己当前设置为false，不需要锁了
        QNode qNode = this.myNode.get();
        qNode.locked = false;
        //设置为前驱节点
        //这样操作tail指向的就是前驱node等同于出队操作
        this.myNode.set(myPrev.get());
    }
}
