package concurrency_test.container_exercise;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample1 {

    private static Random random = new Random(System.currentTimeMillis());

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    private static final CountDownLatch LATCH = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {

        //1 query
        int[] data = queryFromDB();

        //2 do
        for (int i = 0; i < data.length; i++) {
            executorService.submit(new SimpleRunnable(data, i, LATCH));
        }

        //3 wait and close
        /**
         * 场景
         * 串行任务，若到达中间某个阶段有可并行的小任务，则可起多线程并行执行，子线程执行完成后计数器latch减1，
         * 主线程block住，所有子线程任务完成计数减至0后，再串行执行任务
         */
        LATCH.await();
        System.out.println("all of work finished");

        /**
         * 也可借助线程池waitTermination方法结束并行后串行
         * 注意，线程池shutdown方法是异步，仅仅只是发出线程池中正在调度的线程以中断信息，开始打断，并不是立即全部close掉
         */
        executorService.shutdown();
    }

    private static int[] queryFromDB() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    static class SimpleRunnable implements Runnable {

        private final int[] data;

        private final int index;

        private final CountDownLatch latch;

        SimpleRunnable(int[] data, int index, CountDownLatch latch) {
            this.data = data;
            this.index = index;
            this.latch = latch;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(random.nextInt(2_000));
            } catch (Exception e) {
                e.printStackTrace();
            }

            int val = data[index];

            if (val % 2 == 0) {
                data[index] = val * 2;
            } else {
                data[index] = val * 100;
            }

            System.out.println(Thread.currentThread().getName() + " finished");
            latch.countDown();

        }
    }

}
