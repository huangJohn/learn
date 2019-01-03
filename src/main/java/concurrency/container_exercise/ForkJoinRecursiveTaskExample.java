package concurrency.container_exercise;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/3
 */
public class ForkJoinRecursiveTaskExample {

    /**
     * Description:fork join 框架采用分而治之的思想，一个线程可以拆分两个线程，子线程做完后再聚合，循环分再聚合
     *
     * @param
     * @return
     */

    private static final int TH = 6;


    public static void main(String[] args) {

        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> future = forkJoinPool.submit(new CalculateSumRecursiveTask(0, 100));

        try {
            Integer integer = future.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * Description:继承RecursiveTask<Integer>，表示复写的compute方法有返回值
     *
     * @param
     * @return
     */
    private static class CalculateSumRecursiveTask extends RecursiveTask<Integer> {

        private final int start;
        private final int end;

        private CalculateSumRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {

            if (end - start <= TH) {
                return IntStream.rangeClosed(start, end).sum();
            } else {
                int mid = (start + end) / 2;
                CalculateSumRecursiveTask task1 = new CalculateSumRecursiveTask(start, mid);
                CalculateSumRecursiveTask task2 = new CalculateSumRecursiveTask(mid + 1, end);
                task1.fork();
                task2.fork();
                return task1.join() + task2.join();
            }
        }
    }
}
