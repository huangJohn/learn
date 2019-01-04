package concurrency_test.lock_defined;


import java.util.Collection;

/**
 * @author zhuanghuang
 * @date 2018/6/7
 */

public interface Lock {
    void lock() throws InterruptedException;

    void lock(long ms) throws InterruptedException, TimeOutException;

    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockedThreadSize();
}
