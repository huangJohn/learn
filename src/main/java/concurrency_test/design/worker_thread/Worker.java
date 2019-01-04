package concurrency_test.design.worker_thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */

public class Worker extends Thread {

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    private final ProductionChannel channel;

    public Worker(String workerName, ProductionChannel channel) {
        super(workerName);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Production production = channel.takeProduction();
                System.out.println(getName() + " process the " + production.toString());
                production.create();
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
