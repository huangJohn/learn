package concurrency.container_exercise;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/2
 */
public class CountDownLatchExample3 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread mainThread = Thread.currentThread();

        new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            countDownLatch.countDown();
//            mainThread.interrupt();

        }).start();

        /**
         * Description:await(2, TimeUnit.SECONDS)被中断或者超时后立即返回
         *
         * @param
         * @return
         */
        countDownLatch.await(2, TimeUnit.SECONDS);
        System.out.println("=============");
        countDownLatch.countDown();

    }

}
