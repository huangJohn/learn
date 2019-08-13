package com.zh.learn.design_patterns.worker_thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-13
 */
public class Worker extends Thread {

    private final ProductionChannel productionChannel;

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public Worker(String workerName, ProductionChannel productionChannel) {
        super(workerName);
        this.productionChannel = productionChannel;
    }

    @Override
    public void run() {

        while (true) {
            Production production = productionChannel.takeProduction();
            System.out.println(getName() + " process the " + production);
            production.create();
            try {
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
