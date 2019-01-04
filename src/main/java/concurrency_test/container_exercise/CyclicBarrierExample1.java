package concurrency_test.container_exercise;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/3
 */
public class CyclicBarrierExample1 {

    /**
     * Description:
     * CountDownLatch和CyclicBarrier的主要区别是：
     * 1、latch：
     * 裁判
     * thread1 ---->         |
     * thread2 ------->      |
     * thread3 -->           |
     * thread4 ---------->   |
     * <p>
     * 2、cyclicBarrier
     * (裁判不存在)
     * thread1     ---->
     * thread2  ---->
     * thread3    ---->
     * thread4     ---->
     * <p>
     * latch的计数器就等效于一个起点，所有的thread相互之间没有依赖关系，await只依赖这个"裁判员"，
     * 大家都到达计数器0点后，开始下一阶段的代码工作
     * 而cyclicBarrier则不是，不存在这个"裁判员的线"，thread之间有依赖关系，await时是看parties之间的状态，所有
     * parties await之后就可以干其他工作了
     * 并且，latch的计数器到0之后，是不能循环的，而cycleBarrier的计数器是可以循环的
     *
     * @param
     * @return
     */

    public static void main(String[] args) throws InterruptedException {

        /**
         * Description:构造灵活，支持所有线程await后回调通知
         *
         * @param
         * @return
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("all of workers finished done");
            }
        });

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println(Thread.currentThread().getName() + " finished done");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + " do other work");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread("t2") {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("t2 finished.");
                    cyclicBarrier.await();
                    System.out.println("t2 The other thread finished too.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        /*总共就2个await，主线程加入后，barrier可循环reset*/
//        try {
//            cyclicBarrier.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        }

        while (true) {
            System.out.println(cyclicBarrier.getNumberWaiting());//输出当前已经进入await的parties
            System.out.println(cyclicBarrier.getParties());//输出cyclicBarrier的总共parties

            /**
             * Description:
             *
             * if one or more parties broke out of this
             *      *         barrier due to interruption or timeout since
             *      *         construction or the last reset, or a barrier action
             *      *         failed due to an exception; {@code false} otherwise.
             *
             * @param
             * @return
             */
            System.out.println(cyclicBarrier.isBroken());
            TimeUnit.SECONDS.sleep(1);
        }

    }
}
