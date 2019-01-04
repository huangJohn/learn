package concurrency_test.design.future;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class Client {

    public static void main(String[] args) throws InterruptedException {

        FutureService<Void, Void> futureService = FutureService.newService();
        Future<?> future = futureService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i am finish done");
        });
        //get方法会使当前线程进入阻塞
        System.out.println(future.get());

        FutureService<String, Integer> service = FutureService.newService();
        Future<Integer> future1 = service.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        }, "hello");
        //get方法会使当前线程进入阻塞
        System.out.println(future1.get());

        FutureService<String, Integer> service2 = FutureService.newService();
        Future<Integer> future2 = service2.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        }, "hello", System.out::println);

        System.out.println("123");

    }


}
