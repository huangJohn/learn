package concurrency.lock_defined;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author zhuanghuang
 * @date 2018/6/7
 */

public class BooleanLock implements Lock {

    private boolean initValue;

    private Collection<Thread> blockedThreadCollection = new ArrayList<>();

    private Thread currentThread;

    public BooleanLock() {
        this.initValue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue) {
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }

        blockedThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void lock(long ms) throws InterruptedException, TimeOutException {
        if (ms <= 0) {
            lock();
        }

        long hasRemaining = ms;
        long endTime = System.currentTimeMillis() + ms;

        while (initValue) {
            if (hasRemaining <= 0) {
                throw new TimeOutException("time out");
            }
            blockedThreadCollection.add(Thread.currentThread());
            this.wait(ms);
            hasRemaining = endTime - System.currentTimeMillis();
        }
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void unlock() {
        if (currentThread == Thread.currentThread()) {
            this.initValue = false;
            System.out.println(Thread.currentThread().getName() + " release the lock monitor.");
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {

        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedThreadSize() {
        return blockedThreadCollection.size();
    }
}
