package concurrency.container_exercise;

import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/3
 */
public class ForkJoinRecursiveActionExample {

    private static final AtomicInteger SUM = new AtomicInteger(0);

    private static final int TH = 6;

    public static void main(String[] args) {

        final ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.submit(new CalculateSumRecursiveAction(0, 100));

        try {
            forkJoinPool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Optional.of(SUM).ifPresent(System.out::println);
    }

    /**
     * Description:继承RecursiveAction，表示复写的compute方法无返回值，需要外部传入一个变量用于记录和
     *
     * @param
     * @return
     */
    private static class CalculateSumRecursiveAction extends RecursiveAction {

        private final int start;
        private final int end;

        private CalculateSumRecursiveAction(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {

            if (end - start <= TH) {
                SUM.getAndAdd(IntStream.rangeClosed(start, end).sum());
            } else {
                int mid = (start + end) / 2;
                CalculateSumRecursiveAction action1 = new CalculateSumRecursiveAction(start, mid);
                CalculateSumRecursiveAction action2 = new CalculateSumRecursiveAction(mid + 1, end);
                action1.fork();
                action2.fork();
            }
        }
    }
}
