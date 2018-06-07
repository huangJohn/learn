package concurrency.api_exercise;


import java.util.*;
import java.util.stream.Stream;

/**
 * @author zhuanghuang
 * @date 2018/6/7
 */

public class CaptureService {

    private static final LinkedList<Control> CONTROLLER = new LinkedList<>();

    private static final int MAX_QUEUE = 5;

    public static void main(String[] args) {

        List<Thread> work = new ArrayList<>();
        Stream.of("m1","m2","m3","m4","m5","m6","m7","m8","m9","m10").map(CaptureService::createCaptureThread).forEach(t->{
            t.start();
            work.add(t);
        });

        work.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("All of capture work thread finished").ifPresent(System.out::println);
    }


    private static Thread createCaptureThread(String threadName) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                Optional.of("the worker [ " + Thread.currentThread().getName() + " ] begin to capture data.").ifPresent(System.out::println);
                synchronized (CONTROLLER) {
                    while (CONTROLLER.size() > MAX_QUEUE) {
                        try {
                            CONTROLLER.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    CONTROLLER.addLast(new Control());
                }
                Optional.of("the worker [" + Thread.currentThread().getName() + " ] is working.").ifPresent(System.out::println);
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (CONTROLLER) {
                    Optional.of("the worker [" + Thread.currentThread().getName() + " ] end capture data,").ifPresent(System.out::println);
                    CONTROLLER.removeFirst();
                    CONTROLLER.notifyAll();
                }
            }
        }, threadName);
    }

    private static class Control {
    }


}
