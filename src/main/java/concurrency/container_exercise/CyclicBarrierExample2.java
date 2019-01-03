package concurrency.container_exercise;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/3
 */
public class CyclicBarrierExample2 {

    /**
     * Description:测试barrier reset()，在其他进去await时，barrier被reset则抛出broken异常
     *
     * @param
     * @return
     */
    public static void main(String[] args) throws InterruptedException {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        new Thread() {
            @Override
            public void run() {

                try {
                    TimeUnit.SECONDS.sleep(40);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }

        }.start();

        new Thread(() -> {

            try {
//                TimeUnit.SECONDS.sleep(5);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread() {
            @Override
            public void run() {
                try {
//                    TimeUnit.SECONDS.sleep(5);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        //reset==initial==finished
        TimeUnit.SECONDS.sleep(4);

        System.out.println(cyclicBarrier.getNumberWaiting());//2
        System.out.println(cyclicBarrier.getParties());//3
        System.out.println(cyclicBarrier.isBroken());//false

        TimeUnit.SECONDS.sleep(2);

        /*在barrier等待的过程中，被reset后，broken*/
        cyclicBarrier.reset();

        System.out.println(cyclicBarrier.getNumberWaiting());//0
        System.out.println(cyclicBarrier.getParties());//3
        System.out.println(cyclicBarrier.isBroken());//true
    }
}
