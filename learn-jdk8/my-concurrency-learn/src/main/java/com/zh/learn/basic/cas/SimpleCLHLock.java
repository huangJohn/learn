package com.zh.learn.basic.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/6/23
 */
public class SimpleCLHLock {

    private static Unsafe unsafe = null;
    private static final long valueOffSet;
    private volatile CLHNode tail;

    public class CLHNode {
        private boolean locked = true;
    }

    private static Unsafe getUnsafeInstance() throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
        declaredField.setAccessible(true);
        return (Unsafe) declaredField.get(Unsafe.class);
    }

    static {
        try {
            unsafe = getUnsafeInstance();
            valueOffSet = unsafe.objectFieldOffset(SimpleCLHLock.class.getDeclaredField("tail"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public void lock(CLHNode current) {//调用lock方法时，必须持有当前线程的CLHNode
        CLHNode prev = null;
        for (; ; ) {
            //自旋
            prev = tail;
            if (unsafe.compareAndSwapObject(this, valueOffSet, tail, current)) {
                //cas 加入tail成功，自旋结束
                break;
            }
            //否则其他未竞争到的线程继续自旋
        }
        if (prev != null) {
            //存在前驱node
            while (prev.locked) {

            }
            //while等待前驱释放了锁，当前线程则持锁成功
        }
    }

    public void unlock(CLHNode current) {
        if (!unsafe.compareAndSwapObject(this, valueOffSet, current, null)) {
            //当前持锁线程cas失败，lock=false
            current.locked = false;
        }
    }



}
