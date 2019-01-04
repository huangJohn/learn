package concurrency_test.thread.dead_lock;

/**
 * @author zhuanghuang
 * @date 2018/5/31
 */

public class DeadLock {

    private OtherService otherService;

    public DeadLock(OtherService otherService) {
        this.otherService = otherService;
    }

    private static final Object LOCK = new Object();

    public void d1() {
        synchronized (LOCK) {
            System.out.println("d1==========");
            otherService.s1();
        }
    }

    public void d2() {
        synchronized (LOCK) {
            System.out.println("d2=========");
        }
    }
}
