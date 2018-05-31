package concurrency.thread.dead_lock;

/**
 * @author zhuanghuang
 * @date 2018/5/31
 */

public class OtherService {

    private DeadLock deadLock;

    private static final Object LOCK = new Object();


    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    public void s1() {
        synchronized (LOCK) {
            System.out.println("s1=============");
        }
    }

    public void s2() {
        synchronized (LOCK) {
            System.out.println("s2=============");
            deadLock.d2();
        }
    }
}