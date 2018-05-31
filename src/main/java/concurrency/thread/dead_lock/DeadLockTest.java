package concurrency.thread.dead_lock;

/**
 * @author zhuanghuang
 * @date 2018/5/31
 */

public class DeadLockTest {

    public static void main(String[] args) {

        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeadLock(deadLock);


        new Thread() {
            @Override
            public void run() {
                while (true) {
                    deadLock.d1();
                }
            }
        }.start();

        new Thread(() -> {
            while (true) {
                otherService.s2();
            }
        }).start();
    }
}
