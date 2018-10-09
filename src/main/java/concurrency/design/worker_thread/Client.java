package concurrency.design.worker_thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */

public class Client {

    public static void main(String[] args) {
        final ProductionChannel channel = new ProductionChannel(5);
        AtomicInteger no = new AtomicInteger();
        IntStream.range(1, 8).forEach(
                i -> {
                    new Thread(
                            () -> {
                                while (true) {
                                    channel.offerProduction(new Production(no.getAndIncrement()));
                                    try {
                                        TimeUnit.SECONDS.sleep(current().nextInt(10));
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }).start();
                });
    }
}
