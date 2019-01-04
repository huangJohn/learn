package concurrency_test.container_exercise;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/3
 */
public class ExchangerExample1 {

    /**
     * Description:
     * NOTE:
     * 1.if the pair thread not reached exchange point, the thread will WAITING.
     * 2.use the {@link Exchanger} must be paired.
     * @param
     * @return
     */
    public static void main(String[] args) {

        /**
         * Description:exchanger交换的是两个线程彼此的value，必须是成对，且两个线程都到达point后才可以交换
         *
         * @param
         * @return
         */
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + " started.");

            try {
                TimeUnit.SECONDS.sleep(5);

                String exchange = exchanger.exchange("hello, i come from " + Thread.currentThread().getName());

                System.out.println(Thread.currentThread().getName() + " get result : [" + exchange + "]");
                System.out.println(Thread.currentThread().getName() + " end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "a").start();

        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + " started.");

            try {
                TimeUnit.SECONDS.sleep(10);

                String exchange = exchanger.exchange("hello, i come from " + Thread.currentThread().getName());

                System.out.println(Thread.currentThread().getName() + " get result : [" + exchange + "]");
                System.out.println(Thread.currentThread().getName() + " end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "b").start();

        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + " started.");

            try {
                TimeUnit.SECONDS.sleep(20);
                String result = exchanger.exchange("I am come from c");
                System.out.println(Thread.currentThread().getName() + " Get value [" + result + "]");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end.");
        }, "c").start();

    }
}
