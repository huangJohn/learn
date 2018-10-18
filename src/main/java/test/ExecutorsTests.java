package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhuanghuang
 * @date 2018/10/18
 */

public class ExecutorsTests {
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Future<?> submit = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "\t" + "doing " + finalI);
                }
            });
        }

//        executorService.shutdown();

        for (int i = 11; i < 20; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "\t" + "doing " + finalI);
                }
            });
        }
        executorService.shutdown();

    }
}
