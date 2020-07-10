package com.zh.learn.basic.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Description:
 * 互斥，但线程不会阻塞，对硬件级别的数据缓存更新一致性要求高
 * 适合于持锁时间小的场景
 * <p>
 * Author: zhuanghuang
 * Date: 2020/6/23
 */
public class SimpleSpinLock {

    private static Unsafe UNSAFE;
    private static final long valueOffSet;
    private volatile int value = 0;

    private static Unsafe getUnSafeInstance() throws NoSuchFieldException, IllegalAccessException {
        Field instance = Unsafe.class.getDeclaredField("theUnsafe");
        instance.setAccessible(true);
        return (Unsafe) instance.get(Unsafe.class);
    }

    static {
        try {
            UNSAFE = getUnSafeInstance();
            valueOffSet = UNSAFE.objectFieldOffset(SimpleSpinLock.class.getDeclaredField("value"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public void lock() {
        for (; ; ) {
            int newV = value + 1;
            if (newV == 1) {
                if (UNSAFE.compareAndSwapInt(this, valueOffSet, 0, newV)) {
                    //cas成功，抢到锁的线程return
                    return;
                }
            }
            //否则自旋
        }
    }

    public void unlock() {
        //持锁线程释放锁，cas成功即可，因为排他，持锁的肯定只有1个线程
        UNSAFE.compareAndSwapInt(this, valueOffSet, 1, 0);
    }


}
