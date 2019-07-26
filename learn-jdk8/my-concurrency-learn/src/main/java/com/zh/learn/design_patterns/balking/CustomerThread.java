package com.zh.learn.design_patterns.balking;

import java.io.IOException;
import java.util.Random;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-26
 */
public class CustomerThread extends Thread {

    private final BalkingData balkingData;

    private final Random random = new Random(System.currentTimeMillis());

    public CustomerThread(BalkingData balkingData) {
        super("Customer");
        this.balkingData = balkingData;
    }

    @Override
    public void run() {

        try {
            balkingData.save();
            for (int i = 0; i < 20; i++) {
                balkingData.change("no." + i);
                Thread.sleep(random.nextInt(2000));
                balkingData.save();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
