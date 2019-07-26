package com.zh.learn.design_patterns.balking;

import java.io.IOException;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-26
 */
public class WaiterThread extends Thread {

    private final BalkingData balkingData;

    public WaiterThread(BalkingData balkingData) {
        super("Waiter");
        this.balkingData = balkingData;
    }


    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                balkingData.save();
                Thread.sleep(1000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
