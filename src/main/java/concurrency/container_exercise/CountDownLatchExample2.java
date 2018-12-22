package concurrency.container_exercise;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample2 {

    public static void main(String[] args) throws InterruptedException {

        /*
         * 场景
         * 串行分并行
         * */

        final CountDownLatch latch = new CountDownLatch(1);

        new Thread("A") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " do some initial work");
                try {
                    Thread.sleep(1000);
                    //asy
                    latch.await();
                    System.out.println(Thread.currentThread().getName() + " do other work");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        new Thread("B") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " asy prepare for some data");
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " prepare work done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }

            }
        }.start();

        new Thread("C") {
            @Override
            public void run() {
                try {
                    latch.await();
                    System.out.println(Thread.currentThread().getName() + " release");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

//        Thread.currentThread().join();
    }


}
